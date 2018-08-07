package fmt.StackAndDFS;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        if (!this.minStack.empty()) {
            this.stack.push(x);
            if (x <= this.minStack.peek()) {
                this.minStack.push(x);
            } else {
                this.minStack.push(this.minStack.peek());
            }
        } else {

            this.stack.push(x);
            this.minStack.push(x);
        }
    }

    public void pop() {
        if (this.stack.empty()) {
            return;
        }
        this.stack.pop();
        this.minStack.pop();
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return this.minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
