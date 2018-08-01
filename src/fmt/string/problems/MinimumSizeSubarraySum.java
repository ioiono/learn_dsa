package fmt.string.problems;

import java.util.Arrays;

public class MinimumSizeSubarraySum {

    //brute-force

    /**
     * Complexity Analysis
     * <p>
     * Time complexity: O(n^3)
     * <p>
     * For each element of array, we find all the subarrays starting from that index which is O(n^2)
     * <p>
     * Time complexity to find the sum of each subarray is O(n).
     * Thus, the total time complexity : O(n^2 * n) = O(n^3)
     * <p>
     * Space complexity: O(1) extra space.
     *
     * @param s    target
     * @param nums array
     * @return the minimal length
     */
    private static int minSAL(int s, int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum >= s) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }

        return (min != Integer.MAX_VALUE) ? min : 0;
    }

    //A better brute force
    /**
     * Complexity analysis
     *
     * Time complexity: O(n^2)
     *
     * Time complexity to find all the subarrays is O(n^2)
     *
     * Sum of the subarrays is calculated in O(1)O(1) time.
     * Thus, the total time complexity: O(n^2 * 1) = O(n^2)
     *
     * Space complexity: O(n)O(n) extra space.
     *
     * Additional O(n) space for sums vector than in Approach #1.
     */
    private static int minSAL2(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                // Sum of subarray from ii to jj is calculated as: sum=sums[j]−sums[i]+nums[i],
                // wherein sums[j]−sums[i] is the sum from (i+1)th element to the jth element.

                int sum = sums[j] - sums[i] + nums[i];
                if (sum >= s) {
                    res = Math.min(res, (j - i + 1));
                    break;                    //Found the smallest subarray with sum>=s starting with index i, hence move to next index
                }
            }
        }
        return (res != Integer.MAX_VALUE) ? res : 0;


    }

    //because each element is visited at most, twice,
    //so is more like O(2n), but in big-o you discard constants,
    //then is O(n)
    private static int minTP(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                res = Math.min(res, i + 1 - left); //i + 1− left is the size of current subarray
                sum -= nums[left++];
            }
        }

        return (res != Integer.MAX_VALUE) ? res : 0;
    }

    public static void main(String[] args) {
        System.out.println(minSAL(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSAL2(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minTP(7, new int[]{2, 3, 1, 2, 4, 3}));

        System.out.println(minSAL(213, new int[]{12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12}));
        System.out.println(minSAL2(213, new int[]{12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12}));
        System.out.println(minTP(213, new int[]{12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12}));
    }
}
