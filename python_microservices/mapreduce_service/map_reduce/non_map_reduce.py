import glob
import os
from collections import defaultdict
from concurrent.futures import ThreadPoolExecutor, as_completed
from typing import Dict, List, Text

from .helpers import (
    append_inverted_index,
    get_word2idx,
    map_wordid_docs,
    parse_doc,
)


class Inverted_Index_Generator(object):
    word2docs = defaultdict(list)
    word2idx = defaultdict(int)
    idx = 0

    def __init__(self, data_dir: Text):
        self.data_dir = data_dir

    def generate(self) -> Dict[int, List[int]]:
        with ThreadPoolExecutor(max_workers=10) as executor:
            threads = []
            for f_path in glob.glob(os.path.join(self.data_dir, "*")):
                threads.append(executor.submit(parse_doc, f_path))

            for task in as_completed(threads):
                doc2words = task.result()

                self.word2idx, self.idx = get_word2idx(
                    self.word2idx, self.idx, doc2words
                )
                self.word2docs = append_inverted_index(self.word2docs, doc2words)

        return map_wordid_docs(self.word2docs, self.word2idx)
