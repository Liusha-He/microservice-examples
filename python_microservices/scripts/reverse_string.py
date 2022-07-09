from typing import List


class Solution:
    def reverseString(self, s: List[str]) -> None:
        temp = s[::-1]
        s[:] = temp
