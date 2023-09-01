package utils;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode prev;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val, ListNode next, ListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    public static void printLinkedList(ListNode head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();

    }

    public static void printDoubleLinkedList(ListNode head) {
        System.out.print("Double Linked List: ");
        ListNode end = null;
        while (head != null) {
            System.out.print(head.val + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.val + " ");
            end = end.prev;
        }
        System.out.println();
    }

    public static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    public static ListNode createDoubleLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode pre = head;
        ListNode cur = null;
        for (int i = 1; i < arr.length; i++) {
            cur = new ListNode(arr[i]);
            pre.next = cur;
            cur.prev = pre;
            pre = cur;
        }
        return head;
    }
}
