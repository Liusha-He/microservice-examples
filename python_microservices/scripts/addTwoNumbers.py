class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        ls1, ls2 = self.traverse(l1), self.traverse(l2)

        if len(ls1) > len(ls2):
            ls2 += [0] * (len(ls1) - len(ls2))
        if len(ls1) < len(ls2):
            ls1 += [0] * (len(ls2) - len(ls1))

        ls = []
        for idx, n in enumerate(ls1):
            val = n + ls2[idx]
            ls.append((val % 10, val // 10))

        if len(ls) > 1:
            newL = [0] * len(ls)
            newL[0] += ls[0][0]
            for i in range(1, len(ls)):
                res = ls[i][0] + ls[i - 1][1]
                ls[i - 1] = (ls[i - 1][0], 0)
                if res == 10:
                    ls[i] = (0, 1)
                else:
                    ls[i] = (res, ls[i][1])
                newL[i] = newL[i] + ls[i][0]
            else:
                if ls[-1][1] == 1:
                    newL.append(1)

            l = ListNode(newL[-1])
            for i in range(len(newL) - 2, -1, -1):
                l = ListNode(newL[i], l)
        else:
            if ls[0][1] == 1:
                l = ListNode(val=1)
                l = ListNode(val=ls[-1][0], next=l)
            else:
                l = ListNode(val=ls[-1][0])
        return l

    def traverse(self, l: ListNode) -> list:
        ls = []
        while l.next:
            ls.append(l.val)
            l = l.next
        else:
            ls.append(l.val)
        return ls
