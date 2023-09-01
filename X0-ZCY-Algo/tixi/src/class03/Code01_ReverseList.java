package class03;

import utils.ListNode;

public class Code01_ReverseList {
    /**
     * <a href="https://leetcode.com/problems/reverse-linked-list">Code01_ReverseList.java</a>
     */
    public ListNode reverseList(ListNode head) {
        return reverListRecur(head);
//		return reverseListIter(head);
    }

    public ListNode reverseListIter(ListNode head) {
        ListNode reversed = null, temp;
        while (head != null) {
            temp = head.next;
            head.next = reversed;
            reversed = head;
            head = temp;
        }

        return reversed;
    }

    public ListNode reverListRecur(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode tail = head.next;
        ListNode reversed = reverListRecur(head.next);
        tail.next = head;
        head.next = null;
        return reversed;
    }
}