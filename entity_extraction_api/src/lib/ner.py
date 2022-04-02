import logging
from typing import List, Tuple, Iterable, Dict

from src.lib.rules import find_entities, find_all_in_sentence

_logger = logging.getLogger(__name__)


def extract_en(
    text_pair: Tuple[str, str],
    entity_map: Dict[str, str],
) -> Iterable[str]:
    """This is the wraooer for the core pattern matching function."""
    words = []

    for text in text_pair:
        words.extend(find_all_in_sentence(text))

    entities = find_entities(words, entity_map)

    return set(entities)
