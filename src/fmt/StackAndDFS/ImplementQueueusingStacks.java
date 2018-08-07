package fmt.StackAndDFS;


import java.util.Stack;

class MyQueue {


    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        this.pushStack = new Stack<>();
        this.popStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        this.pushStack.push(x);
    }

    private void transfer() {
        if (!this.popStack.isEmpty()) return;
        while (!this.pushStack.isEmpty()) {
            this.popStack.push(this.pushStack.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        transfer();
        if (popStack.isEmpty()) {
            return -1;
        } else {
            return popStack.pop();
        }

    }

    /**
     * Get the front element.
     */
    public int peek() {
        transfer();

        if (popStack.isEmpty()) {
            return -1;
        } else {
            return popStack.peek();
        }
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        transfer();
        return popStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj = new MyQueue(); obj.push(x); int param_2 =
 * obj.pop(); int param_3 = obj.peek(); boolean param_4 = obj.empty();
 */

public class ImplementQueueusingStacks {
    public static void main(String[] args) {

        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.peek());
        obj.push(3);
        System.out.println(obj.peek());
    }
}

