import os

BASR_DIR = os.path.dirname(os.path.realpath(__file__))

N_OF_WORKERS = 10

ENTITIES_DIR = os.path.join(BASR_DIR, "service/entities.json")
WORD_COUNT_DIR = os.path.join(BASR_DIR, "handler/word_counts.json")
