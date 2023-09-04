package class03;

import java.util.Stack;

public class Code05_GetMinStack {
    // https://leetcode.com/problems/min-stack/
    private static class MinStack {
        private final Stack<Integer> stack = new Stack<>();
        // 相当于存下了每一个 length 的状态下的 min val
        private final Stack<Integer> minStack = new Stack<>();

        public MinStack() {

        }

        public void push(int val) {
            stack.add(val);

            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.add(val);
            } else {
                minStack.add(minStack.peek());
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
