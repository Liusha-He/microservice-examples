from concurrent.futures import ThreadPoolExecutor, as_completed
from typing import List, Dict

import nltk
from nltk import RegexpParser

PATTERNS = """chunk:{<NN.?>*<VBD.?>*<JJ.?>*<NN.?>?}"""


def find_all_in_sentence(text: str) -> List[str]:
    words = nltk.word_tokenize(text)

    pos_tag = nltk.pos_tag(words)

    chunker = RegexpParser(PATTERNS)
    chunk = chunker.parse(pos_tag)

    return [" ".join(w for w, t in ele) for ele in chunk if isinstance(ele, nltk.Tree)]


def _match(token: str, entity_map: Dict[str, str]) -> str:
    """get entity if it's in the entity map."""
    if token in entity_map:
        return entity_map[token]


def find_entities(tokens: List[str], entity_map: Dict[str, str], workers: int = 10) -> List[str]:
    outs = []

    with ThreadPoolExecutor(max_workers=workers) as exec:
        threads = []

        for token in tokens:
            threads.append(exec.submit(_match, token, entity_map))

        for task in as_completed(threads):
            ent = task.result()

            if ent is not None and ent not in outs:
                outs.append(ent)

    return outs
