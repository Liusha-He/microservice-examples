import glob
import json
import os
from concurrent.futures import ProcessPoolExecutor
from itertools import chain
from typing import Text

from helpers import get_word2idx_mr, parse_doc


def create_word2idx(data_dir: Text, out_path: Text, chunksize=1):
    data_files = glob.glob(os.path.join(data_dir, "*"))

    with ProcessPoolExecutor() as pool1:
        parsed_data = pool1.map(parse_doc, data_files, chunksize=chunksize)

        word2idx = get_word2idx_mr(chain(parsed_data))

        with open(out_path, "w") as file:
            json.dump(word2idx, file)


if __name__ == "__main__":
    data_dir = "../tests/dataset"
    out_path = "word2idx.json"

    create_word2idx(data_dir, out_path)
