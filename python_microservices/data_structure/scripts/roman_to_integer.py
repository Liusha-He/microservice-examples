class Solution:
    def romanToInt(self, s: str) -> int:
        rom2int1 = {"I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000}
        rom2int2 = {"IV": 4, "IX": 9, "XL": 40, "XC": 90, "CD": 400, "CM": 900}
        integers = []

        s = s.upper()

        for k, v in rom2int2.items():
            if k in s:
                integers.append(v)
                s = s.replace(k, "")

        for c in s:
            integers.append(rom2int1[c])

        return sum(integers)
