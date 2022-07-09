import json
import os
from collections import defaultdict
from concurrent.futures import ProcessPoolExecutor
from functools import partial
from itertools import chain
from typing import Dict, List

from .helpers import parse_doc_mr


CURRENT_PATH = os.path.dirname(__file__)


class MapReduce(object):
    def __init__(self, map_func, path_to_word2idx=None):
        self.map_func = map_func

        if path_to_word2idx is not None:
            self.path_to_word2idx = path_to_word2idx
        else:
            self.path_to_word2idx = os.path.join(CURRENT_PATH, "word2idx.json")

        with open(self.path_to_word2idx, "r", encoding="utf-8") as file:
            self.word2idx = json.load(file)

    def concat(self, mapped_data):
        concat_data = defaultdict(list)
        for wordid, docid in mapped_data:
            concat_data[wordid].append(docid)

        return concat_data

    def __call__(self, data_files, chunksize=1) -> Dict[int, List[int]]:
        with ProcessPoolExecutor() as pool:
            parsed_data = pool.map(
                partial(parse_doc_mr, word2idx=self.word2idx),
                data_files,
                chunksize=chunksize,
            )
            return self.concat(chain(*parsed_data))
