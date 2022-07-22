from typing import List
from unittest import TestCase

from scripts.array_running_sum import Solution


class TestSolution(TestCase):
    def test_running_sum(self):
        solution = Solution()
        arr1: List[int] = [1, 2, 3, 4]
        self.assertEqual(
            [1, 3, 6, 10], solution.runningSum(arr1), "running sum of arr1 incorrrect."
        )

        arr2: List[int] = [1, 1, 1, 1, 1]
        self.assertEqual(
            [1, 2, 3, 4, 5], solution.runningSum(arr2), "running sum of arr2 incorrect."
        )

        arr3: List[int] = [3, 1, 2, 10, 1]
        self.assertEqual(
            [3, 4, 6, 16, 17],
            solution.runningSum(arr3),
            "running sum of arr3 incorrect.",
        )
