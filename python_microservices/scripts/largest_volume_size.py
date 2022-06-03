from typing import List


class Solution:
    def volumeSize(self, arr: List[int]) -> int:
        vol = []
        for idx1, h in enumerate(arr):
            the_rest = list(range(idx1 + 1, len(arr)))
            if the_rest:
                vol.append(
                    max(
                        [
                            min(arr[idx1], arr[idx2]) * abs(idx1 - idx2)
                            for idx2 in the_rest
                        ]
                    )
                )

        return max(vol)
