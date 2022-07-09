from typing import List


class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        weakest = [[sum(mat[i]), i] for i in range(len(mat))]
        weakest.sort(key=lambda a: a[0])
        return [w[1] for w in weakest[:k]]
