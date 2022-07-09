from unittest import TestCase

from scripts.weakest_rows import Solution


class TestSolution(TestCase):
    def test_k_weakest_rows(self):
        solution = Solution()
        mat = [
            [1, 1, 0, 0, 0],
            [1, 1, 1, 1, 0],
            [1, 0, 0, 0, 0],
            [1, 1, 0, 0, 0],
            [1, 1, 1, 1, 1],
        ]
        self.assertEqual([2, 0, 3], solution.kWeakestRows(mat, 3))

        mat2 = [[1, 0, 0, 0], [1, 1, 1, 1], [1, 0, 0, 0], [1, 0, 0, 0]]
        self.assertEqual([0, 2], solution.kWeakestRows(mat2, 2))
