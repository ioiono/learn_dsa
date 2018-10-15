package fmt.HashTable;

import java.util.*;

/**
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * <p>
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 * <p>
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3 Output: [[1,2],[1,4],[1,6]] Explanation: The first 3 pairs are
 * returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6] Example 2:
 * <p>
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2 Output: [1,1],[1,1] Explanation: The first 2 pairs are returned from
 * the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3] Example 3:
 * <p>
 * Input: nums1 = [1,2], nums2 = [3], k = 3 Output: [1,3],[2,3] Explanation: All possible pairs are returned from the
 * sequence: [1,3],[2,3]
 */
class Tuple implements Comparable<Tuple> {
    int x, y, val;

    Tuple(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Tuple that) {
        return this.val - that.val;
    }
}

public class FindKPairswithSmallestSums {
    // ~3ms
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        List<int[]> res = new ArrayList<>();

        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) return res;
        int m = nums1.length, n = nums2.length;
        for (int i = 0; i <= n - 1; i++) pq.offer(new Tuple(0, i, nums1[0] + nums2[i]));


        for (int i = 0; i < Math.min(k, m * n); i++) {
            Tuple tuple = pq.poll();
            res.add(new int[]{nums1[tuple.x], nums2[tuple.y]});
            if (tuple.x != m - 1) {
                pq.offer(new Tuple(tuple.x + 1, tuple.y, nums1[tuple.x + 1] + nums2[tuple.y]));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 7, 11};
        int[] nums2 = new int[]{2, 4, 6};
        FindKPairswithSmallestSums f = new FindKPairswithSmallestSums();
        for (int[] a : f.kSmallestPairs(nums1, nums2, 3)) {
            System.out.print(Arrays.toString(a));
        }


    }
}
