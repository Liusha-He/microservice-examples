package problems.list_based;

class AddTwoNumbers {
    private long listToInt(ListNode l, long result, int power) {
        if (l == null) {
            return result;
        } else {
            return listToInt(l.next,
                    result + l.val * (long) Math.pow(10, power),
                    power + 1);
        }
    }

    private ListNode intToList(long s) {
        if (s == 0) {
            return null;
        }
        long v = s % 10;
        return new ListNode((int) v,
                intToList((s - v) / 10));
    }

    private ListNode addTwoNumbersHelper(ListNode l1, ListNode l2, int prevCarry) {
        if (l1 == null && l2 == null) {
            if (prevCarry == 0) {
                return null;
            } else {
                return new ListNode(prevCarry);
            }
        }

        int l1Val = 0, l2Val = 0;
        ListNode l1Next = null, l2Next = null;

        if (l1 != null) {
            l1Val = l1.val;
            l1Next = l1.next;
        }
        if (l2 != null) {
            l2Val = l2.val;
            l2Next = l2.next;
        }

        int sum = l1Val + l2Val + prevCarry;
        int carry = sum / 10;

        return new ListNode(sum % 10,
                addTwoNumbersHelper(l1Next, l2Next, carry));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersHelper(l1, l2, 0);
    }

    public long sumTwoNumbers(ListNode l1, ListNode l2) {
        long n1 = listToInt(l1, 0, 0);
        long n2 = listToInt(l2, 0, 0);

        return n1 + n2;
    }
}
