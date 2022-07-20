from collections import defaultdict
from typing import Dict, Iterable, List, Set, Text


def parse_doc(f_path: Text) -> Dict[int, Set[Text]]:
    """create a mapping between document id and a set of words in the document."""
    words = set()
    with open(f_path, "r", encoding="ISO-8859-1") as file:
        for line in file:
            if line.strip():
                line = (
                    line.strip()
                    .replace(".", "")
                    .replace(":", "")
                    .replace(",", "")
                    .replace("!", "")
                    .replace("(", "")
                    .replace(")", "")
                    .replace(";", "")
                    .replace("?", "")
                    .replace('"', "")
                    .replace("[", "")
                    .replace("]", "")
                    .replace("----", " ")
                    .replace("---", " ")
                    .replace("--", " ")
                    .replace("=", " ")
                    .replace("'", "")
                    .replace("/", " ")
                )
                line = line.replace("-", " ")
                words.update([w.strip() for w in line.split()])

    return {int(f_path.split("/")[-1]): words}


def parse_doc_mr(f_path: Text, word2idx: Dict[Text, int]):
    wordid2docid = {}
    doc_id = int(f_path.split("/")[-1])

    with open(f_path, "r", encoding="ISO-8859-1") as file:
        for line in file:
            if line.strip():
                line = (
                    line.strip()
                    .replace(".", "")
                    .replace(":", "")
                    .replace(",", "")
                    .replace("!", "")
                    .replace("(", "")
                    .replace(")", "")
                    .replace(";", "")
                    .replace("?", "")
                    .replace('"', "")
                    .replace("[", "")
                    .replace("]", "")
                    .replace("----", " ")
                    .replace("---", " ")
                    .replace("--", " ")
                    .replace("=", " ")
                    .replace("'", "")
                    .replace("/", " ")
                )
                line = line.replace("-", " ")

                for w in line.split():
                    idx = word2idx[w.strip()]
                    if idx not in wordid2docid:
                        wordid2docid[idx] = doc_id
    wordid2docid = list(wordid2docid.items())
    wordid2docid.sort(key=lambda x: x[0])
    return wordid2docid


def append_inverted_index(
    word2docs: Dict[Text, List], parsed_doc: Dict[int, Set]
) -> Dict[Text, List]:
    """create mappings between word id and corresponding list of document ids."""
    for doc_id, words in parsed_doc.items():
        for word in words:
            word2docs[word].append(doc_id)

    return word2docs


def get_word2idx(
    word2idx: Dict[Text, int], idx: int, parsed_doc: Dict[int, Set]
) -> (Dict[Text, int], int):
    """Create mappings between words and indices"""
    for doc_id, words in parsed_doc.items():
        for word in words:
            if word not in word2idx:
                word2idx[word] = idx
                idx += 1

    return word2idx, idx


def get_word2idx_mr(parsed_data: Iterable[Dict]) -> Dict[Text, int]:
    """Create mappings between words and indices. This function serves the multiprocessing generation process."""
    word2idx = {}
    idx = 0

    for item in parsed_data:
        for i, wordset in item.items():
            for word in wordset:
                if word not in word2idx:
                    word2idx[word] = idx
                    idx += 1
    return word2idx


def get_word2doc_id_mapping(parsed_doc: Dict[int, Set], word2idx: Dict[Text, int]):
    """Create a list of word id and doc id pairs."""
    return [
        (word2idx[word], i) for i, wordset in parsed_doc.items() for word in wordset
    ]


def get_wordid2docid_mapping(
    parsed_doc: Dict[int, Set], word2idx: Dict[Text, int]
) -> Dict[int, int]:
    """"""
    wordid2docid = {}
    for doc_id, words in parsed_doc.items():
        for w in words:
            wordid2docid[word2idx[w]] = doc_id
    return wordid2docid


def map_wordid_docs(
    word2docs: Dict[Text, List], word2idx: Dict[Text, int]
) -> Dict[int, List[int]]:
    """"""
    output = defaultdict(list)
    for word, docs in word2docs.items():
        output[word2idx[word]] = docs

    return output
