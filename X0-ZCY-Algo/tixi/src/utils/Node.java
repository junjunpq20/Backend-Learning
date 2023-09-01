package utils;

public class Node<T> {
    public T value;
    public Node<T> next;
    public Node<T> prev;

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public Node(T value, Node<T> next, Node<T> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public static <T> void printLinkedList(Node<T> head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();

    }

    public static <T> void printDoubleLinkedList(Node<T> head) {
        System.out.print("Double Linked List: ");
        Node<T> end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.prev;
        }
        System.out.println();
    }

    public static <T> Node<T> createLinkedList(T[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Node<T> head = new Node<>(arr[0]);
        Node<T> cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new Node<>(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    public static <T> Node<T> createDoubleLinkedList(T[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Node<T> head = new Node<>(arr[0]);
        Node<T> pre = head;
        Node<T> cur = null;
        for (int i = 1; i < arr.length; i++) {
            cur = new Node<>(arr[i]);
            pre.next = cur;
            cur.prev = pre;
            pre = cur;
        }
        return head;
    }
}
