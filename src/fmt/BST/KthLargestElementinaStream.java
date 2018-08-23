package fmt.BST;

import edu.princeton.cs.algs4.In;

import java.util.Comparator;
import java.util.PriorityQueue;

class KthLargest {

    private PriorityQueue<Integer> q;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.q = new PriorityQueue<>(k);
        for (int i : nums) {
            q.offer(i);
            if (q.size() > k) {
                q.poll();
            }
        }
    }

    public int add(int val) {
        this.q.offer(val);
        while (q.size() > k) {
            q.poll();
        }
        return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such: KthLargest obj = new KthLargest(k, nums); int param_1
 * = obj.add(val);
 */

public class KthLargestElementinaStream {
    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[]{4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, arr);

        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
//
//        PriorityQueue<Integer> que = new PriorityQueue<>(10, Comparator.reverseOrder());
//        que.offer(1);
//        que.offer(3);
//        que.offer(2);
//        que.offer(9);
//
//        System.out.println(que);
//        while (!que.isEmpty()) {
//            System.out.println(que.poll());
//        }
    }
}
