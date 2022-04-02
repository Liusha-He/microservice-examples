import json
import logging
from typing import Optional, List

from src.config import ENTITIES_DIR, N_OF_WORKERS, WORD_COUNT_DIR
from src.lib import extract
from src.handler import clean_text

_logger = logging.getLogger(__name__)


def entity_extraction_service(text: str) -> Optional[List[str]]:
    """a arapper of all stages from input to output"""
    with open(ENTITIES_DIR, "r") as file:
        entities = json.load(file)

    cleaned_text_pair = clean_text(text, WORD_COUNT_DIR)

    entities = extract(
        text_pair=cleaned_text_pair,
        entity_map_list=entities.items(),
        n_workers=N_OF_WORKERS,
    )
    entities = list(entities)

    if len(entities) > 0:
        return list(entities)
    else:
        _logger.info(f"cannot find any phrase in {text}")
