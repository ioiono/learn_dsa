package fmt.DynamicProgramming;

public class MaximumSubarray {
    /**
     * 53. Maximum Subarray
     * <p>
     * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
     * <p>
     * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray [4,-1,2,1] has the largest sum =
     * 6.
     *
     * @param nums
     *
     * @return
     */

    // time : O(n) space : O(n);
    // dp[i]: max sum ends in i-th element.
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i - 1] < 0 ? 0 : dp[i - 1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // time : O(n) space : O(1);
    public int maxSubArray2(int[] nums) {
        int res = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            res = Math.max(res, sum);
        }
        return res;
    }

    public int maxSubArray4(int[] nums) {
        int max = nums[0];
        int dp = 0;
        for (int num : nums) {
            dp = Math.max(num, dp + num);
            max = Math.max(max, dp);
        }
        return max;
    }

    // Runtime: 7 ms, faster than 100.00%
    public int maxSubArray5(int[] nums) {
        int maxSoFar = nums[0], maxEndsHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndsHere = Math.max(nums[i], maxEndsHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndsHere);
        }
        return maxSoFar;
    }

    // bf
    public int maxSubArray3(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(sum, max);
            }
        }
        return max;
    }


    // USing DC
    // Find the maximum possible sum in arr[]
    // such that arr[m] is part of it
    private int maxCrossingSum(int arr[], int l, int m, int h) {
        // Include elements on left of mid.
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--) {
            sum = sum + arr[i];
            if (sum > left_sum)
                left_sum = sum;
        }

        // Include elements on right of mid
        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i = m + 1; i <= h; i++) {
            sum = sum + arr[i];
            if (sum > right_sum)
                right_sum = sum;
        }

        // Return sum of elements on left
        // and right of mid
        return left_sum + right_sum;
    }

    private int maxSubArraySum(int arr[], int l, int h) {
        // Base Case: Only one element
        if (l == h) return arr[l];

        // Find middle point
        int m = (l + h) / 2;

        /*
          Return maximum of following three
          possible cases:
          a) Maximum subarray sum in left half
          b) Maximum subarray sum in right half
          c) Maximum subarray sum such that the subarray crosses the midpoint
         */
        return Math.max(Math.max(maxSubArraySum(arr, l, m),
                maxSubArraySum(arr, m + 1, h)),
                maxCrossingSum(arr, l, m, h));
    }

    public int maxSubArray6(int[] arr) {
        return this.maxSubArraySum(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] ints = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaximumSubarray ms = new MaximumSubarray();
        System.out.println(ms.maxSubArray(ints));
        System.out.println(ms.maxSubArray2(ints));
        System.out.println(ms.maxSubArray3(ints));
        System.out.println(ms.maxSubArray4(ints));
        System.out.println(ms.maxSubArray5(ints));
        System.out.println(ms.maxSubArray5(ints));
        System.out.println(ms.maxSubArray6(ints));
    }
}
