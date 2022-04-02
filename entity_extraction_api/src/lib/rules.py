from typing import List, Tuple
import nltk
from nltk import RegexpParser

PATTERNS = """chunk:{<NN.?>*<VBD.?>*<JJ.?>*<NN.?>?}"""


def find_all_in_sentence(text: str) -> List[str]:
    words = nltk.word_tokenize(text)

    pos_tag = nltk.pos_tag(words)

    chunker = RegexpParser(PATTERNS)
    chunk = chunker.parse(pos_tag)

    return [" ".join(w for w, t in ele) for ele in chunk if isinstance(ele, nltk.Tree)]


def find_entities(entities: List[str], entity_map: Tuple[str, List[str]]):
    outs = []
    for ent in entities:
        if ent in entity_map[1]:
            outs.append(entity_map[0])

    return outs
