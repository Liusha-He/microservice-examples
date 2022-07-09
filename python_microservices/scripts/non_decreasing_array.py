from typing import List


class Solution:
    def checkPossibility(self, nums: List[int]) -> bool:
        def isChangeable(left_arr, right_arr):
            left_possible = True
            right_possible = True

            # if changeable from left end
            if len(left_arr) > 1:
                if left_arr[-2] > right_arr[0]:
                    left_possible = False

            # if changeable from right end
            if len(right_arr) > 1:
                if left_arr[-1] > right_arr[1]:
                    right_possible = False

            if left_possible or right_possible:
                return True
            else:
                return False

        # detect the last two integers
        if len(nums) in {1, 2}:
            return True
        else:
            count = 0
            for idx, _ in enumerate(nums[:-1]):
                left = nums[idx]
                right = nums[idx + 1]
                if left > right:
                    count += 1
                    if not isChangeable(nums[: idx + 1], nums[idx + 1 :]):
                        return False

                if count > 1:
                    return False
            else:
                return True
