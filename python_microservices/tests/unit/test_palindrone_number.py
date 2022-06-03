from unittest import TestCase

from scripts.palindrone_number import Solution


class TestSolution(TestCase):
    def test_is_palindrome(self):
        s = Solution()
        self.assertTrue(s.isPalindrome(121))
        self.assertFalse(s.isPalindrome(-121))
        self.assertFalse(s.isPalindrome(10))
        self.assertFalse(s.isPalindrome(-101))
