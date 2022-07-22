from unittest import TestCase

from scripts.buddy_string import Solution


class TestSolution(TestCase):
    def test_buddy_strings(self):
        s = Solution()
        self.assertTrue(s.buddyStrings("ab", "ba"))
        self.assertFalse(s.buddyStrings("ab", "ab"))
        self.assertTrue(s.buddyStrings("aa", "aa"))
        self.assertTrue(s.buddyStrings("aaaaaaabc", "aaaaaaacb"))
        self.assertTrue(s.buddyStrings("abab", "abab"))
        self.assertFalse(s.buddyStrings("", ""))
        self.assertTrue(s.buddyStrings("abccccccc", "abccccccc"))
        self.assertFalse(s.buddyStrings("abcaa", "abcbb"))
