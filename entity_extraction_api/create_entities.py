import os
import csv
import json

from pattern.en import pluralize, singularize

CATEGORIES_DIR = "src/service"
os.makedirs(CATEGORIES_DIR, exist_ok=True)


def main():
    data = {}
    with open("off_categories.tsv", "r") as f:
        for line in csv.reader(f, delimiter="\t"):
            key = line[1]

            key_split = key.split(":")
            if len(key_split) > 1:
                value = key_split[1]
            else:
                value = key_split[0]

            entity = value.lower().replace("-", " ")
            data[key] = [
                pluralize(entity), singularize(entity), entity
            ]

    with open(os.path.join(CATEGORIES_DIR, "entities.json"), "w") as f:
        json.dump(data, f)


if __name__ == '__main__':
    main()
