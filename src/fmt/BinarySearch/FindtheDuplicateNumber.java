package fmt.BinarySearch;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least
 * one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,4,2,2] Output: 2 Example 2:
 * <p>
 * Input: [3,1,3,4,2] Output: 3 Note:
 * <p>
 * You must not modify the array (assume the array is read only). You must use only constant, O(1) extra space. Your
 * runtime complexity should be less than O(n^2). There is only one duplicate number in the array, but it could be
 * repeated more than once.
 */
public class FindtheDuplicateNumber {

    /**
     * Complexity Analysis
     * <p>
     * Time complexity : O(n)
     * <p>
     * Set in both Python and Java rely on underlying hash tables, so insertion and lookup have amortized constant time
     * complexities. The algorithm is therefore linear, as it consists of a for loop that performs constant work nn
     * times.
     * <p>
     * Space complexity : O(n)
     * <p>
     * In the worst case, the duplicate element appears twice, with one of its appearances at array index n-1n−1. In
     * this case, seen will contain n-1n−1 distinct values, and will therefore occupy O(n)O(n) space.
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n)) {
                return n;
            }
        }
        return -1;
    }

    /**
     * Complexity Analysis
     * <p>
     * Time complexity : O(nlgn)
     * <p>
     * The sort invocation costs O(nlgn) time in Python and Java, so it dominates the subsequent linear scan.
     * <p>
     * Space complexity : O(1) (or O(n))
     * <p>
     * Here, we sort nums in place, so the memory footprint is constant. If we cannot modify the input array, then we
     * must allocate linear space for a copy of nums and sort that instead.
     *
     * @param nums
     * @return
     */
    public int findDuplicateII(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * Pigeonhole Principle O(nlgn), O(1)
     *
     * @param nums
     * @return
     */
    public int findDuplicateIII(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cnt = 0;
            for (int n : nums) {
                if (n <= mid) {
                    cnt++;
                }
            }
            if (cnt > mid) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
    }


    public static void main(String[] args) {
        FindtheDuplicateNumber dup = new FindtheDuplicateNumber();
        int[] n0 = new int[]{1, 3, 4, 2, 2};
        int[] n1 = new int[]{3, 1, 3, 4, 2};
        System.out.println(dup.findDuplicate(n0));
        System.out.println(dup.findDuplicateII(n0));
        System.out.println(dup.findDuplicateIII(n0));

        System.out.println(dup.findDuplicate(n1));
        System.out.println(dup.findDuplicateII(n1));
        System.out.println(dup.findDuplicateIII(n1));
    }
}
