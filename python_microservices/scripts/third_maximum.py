from typing import List


class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        arr = list(set(nums))
        if len(arr) < 3:
            return max(arr)
        else:
            arr.remove(max(arr))
            arr.remove(max(arr))
            return max(arr)
