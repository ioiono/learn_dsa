package fmt.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation above is straightforward but is inefficient in some cases. With the movement of the start pointer,
 * more and more space is wasted. And it will be unacceptable when we only have a space limitation.
 */
class MyQueue {
    // store elements
    private List<Integer> data;
    // a pointer to indicate the start position
    private int pStart;
    MyQueue() {
        data = new ArrayList<>();
        pStart = 0;
    }

    /**
     * Insert an element into the queue. Return true if the operation is successful.
     */
    boolean enQueue(int x) {
        data.add(x);
        return true;
    }

    /**
     * Delete an element from the queue. Return true if the operation is successful.
     */
    boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        pStart++;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    int Front() {
        return data.get(pStart);
    }

    /**
     * Checks whether the queue is empty or not.
     */
    boolean isEmpty() {
        return pStart >= data.size();
    }
}

public class QueueTest {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.enQueue(5);
        q.enQueue(3);
        if (!q.isEmpty()) {
            System.out.println(q.Front());
        }
        q.deQueue();
        if (!q.isEmpty()) {
            System.out.println(q.Front());
        }
        q.deQueue();
        if (!q.isEmpty()) {
            System.out.println(q.Front());
        }
    }
}
