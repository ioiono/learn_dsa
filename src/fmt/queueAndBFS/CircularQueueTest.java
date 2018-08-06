package fmt.queueAndBFS;

class CircularQueue {

    // store elements
    private int[] data;

    private int pStart;
    private int pEnd;
    private int size;

    /**
     * Initialize your data structure here. Set the size of the queueAndBFS to be k.
     */
    CircularQueue(int size) {
        this.data = new int[size];
        this.pStart = -1;
        this.pEnd = -1;
        this.size = size;
    }

    /**
     * Checks whether the circular queueAndBFS is empty or not.
     */
    public boolean isEmpty() {
        return this.pStart == -1 && this.pEnd == -1;
    }

    /**
     * Checks whether the circular queueAndBFS is full or not.
     */
    public boolean isFull() {
        return (this.pEnd + 1) % this.size == this.pStart;
    }

    /**
     * Insert an element into the circular queueAndBFS. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (this.isFull()) {
            return false;
        }
        // set pStart and pEnd to be equal (one element now)
        if (this.isEmpty()) {
            this.pStart = (this.pEnd + 1) % this.size;
        }
        this.pEnd = (this.pEnd + 1) % this.size;
        this.data[this.pEnd] = value;
        return true;
    }

    /**
     * Delete an element from the circular queueAndBFS. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (this.isEmpty()) {
            System.out.println("EMPTY!");
            return false;
        }

        if (this.pStart == this.pEnd) {
            this.pStart = -1;
            this.pEnd = -1;
        } else {
            this.pStart = (this.pStart + 1) % this.size;
        }
        return true;
    }

    /**
     * Get the front item from the queueAndBFS.
     */
    public int Front() {
        return this.isEmpty() ? -1 : this.data[this.pStart];
    }

    /**
     * Get the last item from the queueAndBFS.
     */
    public int Rear() {
        return this.isEmpty() ? -1 : this.data[this.pEnd];
    }

}

public class CircularQueueTest {

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(3); // set the size to be 3
        System.out.println(circularQueue.enQueue(1));  // return true
        System.out.println(circularQueue.enQueue(2));  // return true
        System.out.println(circularQueue.enQueue(3));  // return true
        System.out.println(circularQueue.enQueue(4));  // return false, the queueAndBFS is full
        System.out.println(circularQueue.Rear());  // return 3
        System.out.println(circularQueue.isFull());  // return true
        System.out.println(circularQueue.deQueue());  // return true
        System.out.println(circularQueue.enQueue(4));  // return true
        System.out.println(circularQueue.Rear());  // return 4
    }
}
