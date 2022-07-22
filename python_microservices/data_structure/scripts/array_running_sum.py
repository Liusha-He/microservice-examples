from typing import List


class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        output = []
        s = 0
        for n in nums:
            s += n
            output.append(s)
        return output
