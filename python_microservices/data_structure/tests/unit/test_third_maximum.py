from unittest import TestCase

from scripts.third_maximum import Solution


class TestSolution(TestCase):
    def test_third_max(self):
        s = Solution()
        self.assertEqual(1, s.thirdMax([3, 2, 1]))
        self.assertEqual(2, s.thirdMax([1, 2]))
        self.assertEqual(1, s.thirdMax([2, 2, 3, 1]))
        self.assertEqual(2, s.thirdMax([1, 2, 2, 5, 3, 5]))
