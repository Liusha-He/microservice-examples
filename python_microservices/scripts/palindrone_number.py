import math


class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0 or x > 2 ** 31 or x <= -(2 ** 31):
            return False
        else:
            splitted_x = tuple(
                (x // (10 ** i)) % 10
                for i in range((math.floor(math.log10(x)) if x != 0 else 0), -1, -1)
            )
            return splitted_x == splitted_x[::-1]
