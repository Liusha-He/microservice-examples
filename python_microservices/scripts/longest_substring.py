class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
        else:
            maxLen = 0
            sset = ""

            for c in s:
                idx = sset.find(c)

                if idx >= 0:
                    sset = sset.replace(sset[0 : idx + 1], "")
                sset += c
                if len(sset) > maxLen:
                    maxLen = len(sset)
            return maxLen


if __name__ == "__main__":
    solution = Solution()
    print(solution.lengthOfLongestSubstring("abcabcbb"))
