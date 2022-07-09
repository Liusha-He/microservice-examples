from unittest import TestCase

from scripts.reverse_string import Solution


class TestSolution(TestCase):
    def test_reverse_string(self):
        s = Solution()
        arr1 = ["h", "e", "l", "l", "o"]
        s.reverseString(arr1)
        self.assertEqual(["o", "l", "l", "e", "h"], arr1)

        arr2 = ["H", "a", "n", "n", "a", "h"]
        s.reverseString(arr2)
        self.assertEqual(["h", "a", "n", "n", "a", "H"], arr2)
