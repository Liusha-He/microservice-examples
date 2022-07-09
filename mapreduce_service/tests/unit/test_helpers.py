import unittest
from collections import defaultdict

from map_reduce.helpers import (
    append_inverted_index,
    get_word2idx,
    map_wordid_docs
)


class TestHelpers(unittest.TestCase):
    def setUp(self) -> None:
        self.docid2words = [
            {0: {"a", "b", "c"}},
            {2: {"a", "b", "d"}},
        ]

    def test_append_inverted_index(self):
        inverted_index = defaultdict(list)
        for i in self.docid2words:
            inverted_index = append_inverted_index(inverted_index, i)

        self.assertEqual({"a": [0,2], "b": [0,2], "c": [0], "d": [2]},
                         inverted_index,
                         "The output incorrect")

    def test_get_word2idx(self):
        word2idx = defaultdict(int)
        idx = 0

        for i in self.docid2words:
            word2idx, idx = get_word2idx(word2idx, idx, i)

        self.assertEqual(4, idx, "The idx should be 4")
        self.assertTrue(all([k in {"a", "b", "c", "d"} and v in range(4) for k, v in word2idx.items()]),
                        "The items in the word-index mapping are not correct.")

    def test_map_wordid_docs(self):
        word2docs = {"a": [1,2,3],
                     "b": [1,2],
                     "c": [0,1,8],
                     "d": [0]}
        word2idx = {"a": 0, "b": 1, "c": 3, "d": 100}

        res = map_wordid_docs(word2docs, word2idx)

        self.assertEqual({0: [1, 2, 3], 1: [1, 2], 3: [0, 1, 8], 100: [0]}, res,
                         "The final outputs incorrect.")