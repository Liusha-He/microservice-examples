class Solution:
    def buddyStrings(self, A: str, B: str) -> bool:
        if len(A) != len(B) or any(not x for x in [A, B]):
            return False
        else:
            if A == B:
                return True if len(set(A)) <= len(A) / 2 else False
            else:
                if set(A) != set(B):
                    return False
                else:
                    cimap_a, cimap_b = {}, {}
                    for a, b in zip(A, B):
                        if a != b:
                            if a not in cimap_a:
                                cimap_a[a] = 1
                            else:
                                cimap_a[a] += 1
                            if b not in cimap_b:
                                cimap_b[b] = 1
                            else:
                                cimap_b[b] += 1

                            if cimap_a[a] > 1:
                                return False
                            if cimap_b[b] > 1:
                                return False

                        if len(cimap_a) > 2:
                            return False
                        if len(cimap_b) > 2:
                            return False

                    else:
                        return True
