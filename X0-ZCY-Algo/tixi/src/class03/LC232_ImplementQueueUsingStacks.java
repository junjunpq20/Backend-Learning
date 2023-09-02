package class03;

import java.util.Stack;

/**
 * Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity?
 * In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.
 */
public class LC232_ImplementQueueUsingStacks {
    private final Stack<Integer> pushStack = new Stack<>();
    private final Stack<Integer> popStack = new Stack<>();

    public void push(int x) {
        pushStack.push(x);
    }

    public int pop() {
        peek();

        if (popStack.isEmpty()) return -1;
        return popStack.pop();
    }

    public int peek() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }

        if (popStack.isEmpty()) return -1;
        return popStack.peek();
    }

    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}
