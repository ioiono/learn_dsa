package fmt.QueueAndBFS;

import java.util.Collections;
import java.util.PriorityQueue;

public class PQTest {

    public int kthLargest(int[] nums, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.offer(val);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        System.out.println(pq);
        return pq.peek();
    }

    public int kthLargest2(int[] nums, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.offer(val);
        }
        System.out.println(pq);
        while (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }

    public int kthSmallest(int[] nums, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(10, Collections.reverseOrder());
        for (int val : nums) {
            pq.offer(val);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        System.out.println(pq);
        return pq.peek();
    }

    public int kthSmallest2(int[] nums, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(10, Collections.reverseOrder());
        for (int val : nums) {
            pq.offer(val);


        }
        System.out.println(pq);
        while (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 6, 2, 7, 1, 0, 5, 2};
        PQTest p = new PQTest();
        System.out.println(p.kthLargest(nums, 1));
        System.out.println(p.kthLargest2(nums, 1));
        System.out.println(p.kthSmallest(nums, 1));
        System.out.println(p.kthSmallest2(nums, 1));
    }
}
