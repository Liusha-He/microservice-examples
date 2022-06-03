from typing import List


class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        res = [[1]]

        for n in range(1, numRows):
            row = [v + res[-1][i] for i, v in enumerate(res[-1][1:])]
            row.insert(0, 1)
            row.insert(n, 1)

            res.append(row)

        return res


if __name__ == "__main__":
    sol = Solution()
    print(sol.generate(5))
