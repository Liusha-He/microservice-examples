class Solution:
    def reverse(self, x: int) -> int:
        if x == 0:
            return 0
        else:
            res = int(str(x)[::-1].replace("-", ""))
            if res >= 2 ** 31:
                return 0
            else:
                if x < 0:
                    return -res
                else:
                    return res
