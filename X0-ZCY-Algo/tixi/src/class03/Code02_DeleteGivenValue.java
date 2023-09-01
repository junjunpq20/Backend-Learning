package class03;

import utils.ListNode;

public class Code02_DeleteGivenValue {
    /**
     * <a href="https://leetcode.com/problems/remove-linked-list-elements/">203. Remove Linked List Elements</a>
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode ptr = dummy;

        while (ptr.next != null) {
            if (ptr.next.val == val) {
                ptr.next = ptr.next.next;
            } else {
                ptr = ptr.next;
            }
        }

        return dummy.next;
    }
}
