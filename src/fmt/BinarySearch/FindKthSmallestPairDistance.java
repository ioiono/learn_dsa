package fmt.BinarySearch;

import java.util.*;

/**
 * Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) is
 * defined as the absolute difference between A and B.
 * <p>
 * Example 1: Input: nums = [1,3,1] k = 1 Output: 0 Explanation: Here are all the pairs: (1,3) -> 2 (1,1) -> 0 (3,1) ->
 * 2 Then the 1st smallest distance pair is (1,1), and its distance is 0. Note: 2 <= len(nums) <= 10000. 0 <= nums[i] <
 * 1000000. 1 <= k <= len(nums) * (len(nums) - 1) / 2.
 */
public class FindKthSmallestPairDistance {


    // Memory Limit Exceeded O(N^2) O(N^2)
    public static int smallestDistancePair(int[] nums, int k) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                list.add(Math.abs(nums[i] - nums[j]));
            }
        }
        if (k - 1 >= list.size()) {
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(list);
        while (k-- > 1) {
            pq.poll();
        }

        return pq.peek();
    }

    // Time Limit Exceeded
    public static int smallestDistancePair2(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(10, Collections.reverseOrder());

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                pq.add(Math.abs(nums[i] - nums[j]));
                while (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        System.out.println(Arrays.toString(pq.toArray()));

        return pq.peek();
    }

    /**
     * Time Complexity: O(NlogW+NlogN), where NN is the length of nums, and W is equal to nums[nums.length - 1] - nums[0].
     * The logW factor comes from our binary search, and we do O(N) work inside our call to possible (or to calculate count in Java).
     * The final O(NlogN) factor comes from sorting.
     *
     * Space Complexity: O(1). No additional space is used except for integer variables.
     * @param nums
     * @param k
     * @return
     */
    public int smallestDistancePair3(int[] nums, int k) {
        Arrays.sort(nums);

        int lo = 0;
        int hi = nums[nums.length - 1] - nums[0];
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            int count = 0, left = 0;
            for (int right = 0; right < nums.length; ++right) {
                while (nums[right] - nums[left] > mi) left++;
                count += right - left;
            }
            //count = number of pairs with distance <= mi
            if (count >= k) hi = mi;
            else lo = mi + 1;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 6};
        System.out.println(smallestDistancePair2(nums, 2));

    }
}
