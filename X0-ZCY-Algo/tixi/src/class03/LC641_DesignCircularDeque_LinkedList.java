package class03;

public class LC641_DesignCircularDeque_LinkedList {
    private final int capacity;

    private Node head = null;
    private Node tail = null;

    private int size = 0;

    public LC641_DesignCircularDeque_LinkedList(int k) {
        this.capacity = k;
    }

    private boolean init(int value) {
        if (isEmpty()) {
            Node node = new Node(value);
            this.head = node;
            this.tail = node;
            this.size = 1;
            return true;
        }
        return false;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;

        if (isEmpty()) {
            return init(value);
        }

        Node node = new Node(value);
        node.next = this.head;
        head.prev = node;
        this.head = node;
        this.size += 1;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;

        if (isEmpty()) {
            return init(value);
        }

        Node node = new Node(value);
        this.tail.next = node;
        node.prev = this.tail;
        this.tail = node;
        this.size += 1;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;

        if (this.size == 1) {
            this.size = 0;
            this.head = null;
            this.tail = null;
            return true;
        }

        this.size -= 1;
        Node newHead = this.head.next;
        this.head.next = null;
        newHead.prev = null;
        this.head = newHead;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;

        if (this.size == 1) {
            this.size = 0;
            this.head = null;
            this.tail = null;
            return true;
        }

        this.size -= 1;
        Node newTail = this.tail.prev;
        this.tail.prev = null;
        newTail.next = null;
        this.tail = newTail;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return this.head.val;
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return this.tail.val;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.capacity == this.size;
    }

    private static class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }
    }
}
