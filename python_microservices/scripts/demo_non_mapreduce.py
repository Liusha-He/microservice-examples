from map_reduce.non_map_reduce import Inverted_Index_Generator


DATADIR = "../dataset"

if __name__ == "__main__":
    gen = Inverted_Index_Generator(DATADIR)

    inverted_index = gen.generate()

    print(inverted_index)
