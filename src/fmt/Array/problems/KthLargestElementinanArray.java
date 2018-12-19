package fmt.Array.problems;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElementinanArray {
    // O(N lg K) running time + O(K) memory
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * O(N) best case / O(N^2) worst case running time + O(1) memory
     *
     * @param nums
     * @param k
     *
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {

        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.offer(val);

            if (pq.size() > k) {
                pq.poll(); // polls smallest el first
            }
        }
        System.out.println(pq); // k largest els
        return pq.peek();
    }

    /**
     * selection algorithm (based on the partition method - the same one as used in quick sort).
     * O(N) guaranteed running time + O(1) space
     *
     * @param nums
     * @param k
     *
     * @return
     */
    public int findKthLargest3(int[] nums, int k) {

        shuffle(nums);
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if (j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int start, int end) {
       final int pivot = a[end];
        int pIndex = start;

        for (int i = start; i < end; i++) {
            if (less(a[i] , pivot)) {
                this.exch(a, pIndex++, i);
            }
        }
        exch(a, pIndex, end);
        return pIndex;
    }
//    private int partition(int[] a, int lo, int hi) {
//
//        int i = lo;
//        int j = hi + 1;
//        while (true) {
//            while (i < hi && less(a[++i], a[lo])) ;
//            while (j > lo && less(a[lo], a[--j])) ;
//            if (i >= j) {
//                break;
//            }
//            exch(a, i, j);
//        }
//        exch(a, lo, j);
//        return j;
//    }

    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean less(int v, int w) {
        return v < w;
    }

    private void shuffle(int a[]) {
        final Random random = new Random();
        for (int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1); // [0, idn]
            exch(a, ind, r);
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[]{-1, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        KthLargestElementinanArray k = new KthLargestElementinanArray();
        System.out.println(k.findKthLargest(ints, 4));
        System.out.println(k.findKthLargest2(ints, 4));
        System.out.println(k.findKthLargest3(ints, 4));
    }
}
