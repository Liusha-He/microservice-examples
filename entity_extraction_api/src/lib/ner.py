import logging
from concurrent.futures import ThreadPoolExecutor, as_completed
from typing import List, Tuple, Iterable

from src.lib.rules import find_entities, find_all_in_sentence

_logger = logging.getLogger(__name__)


def extract(
    text_pair: Tuple[str, str],
    entity_map_list: List[Tuple[str, List[str]]],
    n_workers: int = 10,
) -> Iterable[str]:
    """This is the wraooer for the core pattern matching function."""
    words = []
    for text in text_pair:
        words.extend(find_all_in_sentence(text))

    with ThreadPoolExecutor(max_workers=n_workers) as executor:
        threads = []
        for entity_map in entity_map_list:
            threads.append(executor.submit(find_entities, words, entity_map))

        _matches = []
        for task in as_completed(threads):
            entities = task.result()

            if entities is not None and entities not in _matches:
                _matches.extend(entities)

        return set(_matches)
