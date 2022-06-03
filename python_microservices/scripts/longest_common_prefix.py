from typing import List


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs:
            return ""
        elif len(strs) == 1:
            return strs[0]
        else:
            first_str = strs[0]
            rest_strs = strs[1:]

            if first_str:
                stop = False
                all_long = False
                idx = 1
                pattern = ""

                while not stop:
                    pattern = first_str[:idx]
                    if (
                        len(list(filter(lambda w: pattern == w[:idx], rest_strs)))
                        != len(strs) - 1
                    ):
                        stop = True
                    elif idx == len(first_str):
                        all_long = True
                        stop = True
                    else:
                        idx += 1

                if not all_long:
                    return pattern[:-1] if len(pattern) > 1 else ""
                else:
                    return pattern
            else:
                return ""
