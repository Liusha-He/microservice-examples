package problems.list_based;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddTwoNumbersTest {
    @Test public void addTwoNumbers() {
        ListNode l1 = new ListNode(8,
                new ListNode(8,
                        new ListNode(9,
                                new ListNode(1))));
        ListNode l2 = new ListNode(3, new ListNode(3));

        AddTwoNumbers s = new AddTwoNumbers();

        ListNode expResult = new ListNode(1,
                new ListNode(2,
                        new ListNode(0,
                                new ListNode(2))));

        ListNode res = s.addTwoNumbers(l1, l2);

        assertEquals(expResult.val, res.val);
        assertEquals(expResult.next.val, res.next.val);
        assertEquals(expResult.next.next.val, res.next.next.val);
        assertEquals(expResult.next.next.next.val, res.next.next.next.val);

        ListNode ls1 = new ListNode(1,
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(9,
                                        new ListNode(9,
                                                new ListNode(9,
                                                        new ListNode(9,
                                                                new ListNode(9,
                                                                        new ListNode(9,
                                                                                new ListNode(9))))))))));
        ListNode ls2 = new ListNode(9);

        long exp = 10_000_000_000L;

        assertEquals(exp, s.sumTwoNumbers(ls1, ls2));
    }
}