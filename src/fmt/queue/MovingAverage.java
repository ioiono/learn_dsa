package fmt.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * class MovingAverage { public: MovingAverage(int size) { this->size = size; sum = 0; }
 * <p>
 * double next(int val) { if (q.size() >= size) { sum -= q.front(); q.pop(); } q.push(val); sum += val; return sum /
 * q.size(); }
 * <p>
 * private: queue<int> q; int size; double sum; };
 */
public class MovingAverage {

    private int size;
    private double sum;

    private Queue<Integer> queue;

    MovingAverage(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
        this.sum = 0;
    }

    private double next(int val) {
        if (this.queue.size() >= this.size) {
            sum -= this.queue.poll();
        }
        this.queue.offer(val);
        this.sum += val;
        return sum / this.queue.size();
    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(2));
        System.out.println(m.next(3));
        System.out.println(m.next(4));

    }
}
