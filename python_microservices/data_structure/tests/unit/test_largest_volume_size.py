from unittest import TestCase

from scripts.largest_volume_size import Solution


class TestSolution(TestCase):
    def test_volume_size(self):
        s = Solution()
        self.assertEqual(12, s.volumeSize([1, 3, 8, 7, 2, 4]))
