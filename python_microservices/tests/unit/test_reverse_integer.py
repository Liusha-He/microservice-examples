from unittest import TestCase

from scripts.reverse_integer import Solution


class TestSolution(TestCase):
    def test_reverse(self):
        s = Solution()
        self.assertEqual(21, s.reverse(120))
        self.assertEqual(321, s.reverse(123))
        self.assertEqual(-321, s.reverse(-123))
        self.assertEqual(0, s.reverse(0))
