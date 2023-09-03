package class03;

public class Code04_RingArray {
    /**
     * <a href="https://leetcode.com/problems/design-circular-deque/description/">641. Design Circular Deque</a>
     */
    private static class MyCircularDeque {
        private final int[] arr;
        private final int capacity;
        private int size = 0;
        private int head = 0;
        private int tail = 0;

        /**
         * @param k >= 1
         */
        public MyCircularDeque(int k) {
            arr = new int[k];
            capacity = k;
        }

        public boolean addFirst(int value) {
            if (!isEmpty()) return false;

            head = 0;
            tail = 0;
            arr[0] = value;
            size = 1;
            return true;
        }

        public boolean insertFront(int value) {
            if (isEmpty()) return addFirst(value);
            if (isFull()) return false;

            int newHead = (((head - 1) % arr.length) + arr.length) % arr.length;
            arr[newHead] = value;
            head = newHead;
            size += 1;
            return true;
        }

        public boolean insertLast(int value) {
            if (isEmpty()) return addFirst(value);
            if (isFull()) return false;

            int newTail = (tail + 1) % arr.length;
            arr[newTail] = value;
            tail = newTail;
            size += 1;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) return false;

            head = (head + 1) % arr.length;
            size -= 1;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) return false;

            tail = (((tail - 1) % arr.length) + arr.length) % arr.length;
            size -= 1;
            return true;
        }

        public int getFront() {
            return isEmpty() ? -1 : arr[head];
        }

        public int getRear() {
            return isEmpty() ? -1 : arr[tail];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }
}
