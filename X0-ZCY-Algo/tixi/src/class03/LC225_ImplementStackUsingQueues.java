package class03;

import java.util.LinkedList;
import java.util.Queue;

public class LC225_ImplementStackUsingQueues {
    private final Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        if (queue.isEmpty()) return -1;
        return queue.remove();
    }

    public int top() {
        if (queue.isEmpty()) return -1;
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
