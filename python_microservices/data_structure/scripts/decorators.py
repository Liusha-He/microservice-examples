import datetime
import os


def log(*args, path=None, **kwargs):
    logfile = os.path.join(path, "log.txt") if path else "log.txt"

    def out_wrapper(func):
        def inner_wrapper(*args, **kwargs):
            with open(logfile, "a+") as file:
                file.write(
                    "called function with "
                    + " ".join([str(arg) for arg in args])
                    + " at {}".format(datetime.datetime.now())
                    + "\n"
                )
            val = func(*args, **kwargs)
            print("inner wrapper is called")
            return val * 2

        print("out wrapper called")
        return inner_wrapper

    print("The end of decorator")
    return out_wrapper


@log(path="data/")
def run(a, b, c=9):
    return a + b + c


if __name__ == "__main__":
    res = run(8, 11, 19)
    print(res)
