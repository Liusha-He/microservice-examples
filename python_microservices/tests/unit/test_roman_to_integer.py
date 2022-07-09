from unittest import TestCase

from scripts.roman_to_integer import Solution


class TestSolution(TestCase):
    def test_roman_to_int(self):
        ans = Solution()
        self.assertEqual(3, ans.romanToInt("III"))
        self.assertEqual(4, ans.romanToInt("IV"))
        self.assertEqual(9, ans.romanToInt("IX"))
        self.assertEqual(58, ans.romanToInt("LVIII"))
        self.assertEqual(1994, ans.romanToInt("MCMXCIV"))
