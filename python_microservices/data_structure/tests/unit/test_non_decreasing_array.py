from unittest import TestCase

from scripts.non_decreasing_array import Solution


class TestSolution(TestCase):
    def test_is_changeable(self):
        s = Solution()
        self.assertTrue(s.checkPossibility([4, 2, 3]))
        self.assertFalse(s.checkPossibility([4, 2, 1]))
        self.assertFalse(s.checkPossibility([3, 4, 2, 3]))
        self.assertTrue(s.checkPossibility([-1, 4, 2, 3]))
        self.assertTrue(s.checkPossibility([1, 3, 2]))
        self.assertFalse(s.checkPossibility([2, 3, 3, 2, 2]))
        self.assertTrue(s.checkPossibility([5, 7, 1, 8]))
        self.assertFalse(s.checkPossibility([1, 5, 4, 6, 7, 10, 8, 9]))
        self.assertFalse(s.checkPossibility([12, 8, 15, 11, 13, 14]))
        self.assertTrue(s.checkPossibility([1, 2, 3, 5, 4]))
