from unittest import TestCase

from scripts.longest_common_prefix import Solution


class TestSolution(TestCase):
    def test_longest_common_prefix(self):
        s = Solution()
        self.assertEqual("fl", s.longestCommonPrefix(["flower", "flow", "flight"]))
        self.assertEqual("", s.longestCommonPrefix(["dog", "racecar", "car"]))
        self.assertEqual("", s.longestCommonPrefix([]))
        self.assertEqual("abc", s.longestCommonPrefix(["abc"]))
