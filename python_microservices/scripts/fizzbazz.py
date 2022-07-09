def rec_fizz_bazz(a: int, n: int):
    if a <= n:
        print(
            "fizz bazz"
            if a % 15 == 0
            else "fizz"
            if a % 3 == 0
            else "bazz"
            if a % 5 == 0
            else a
        )
        rec_fizz_bazz(a + 1, n)
    else:
        return


if __name__ == "__main__":
    print("Normal Solution Result")
    for i in range(1, 101):
        print(
            "fizz bazz"
            if i % 15 == 0
            else "fizz"
            if i % 3 == 0
            else "bazz"
            if i % 5 == 0
            else i
        )

    print("Recursive Solution Result")
    rec_fizz_bazz(1, 100)
