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

    // bf
    public int maxSubArray3(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                System.out.print(nums[j] + ", ");
                sum += nums[j];
                max = Math.max(sum, max);
            }
            System.out.println();
        }
        return max;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaximumSubarray ms = new MaximumSubarray();
        System.out.println(ms.maxSubArray(ints));
        System.out.println(ms.maxSubArray2(ints));
        System.out.println(ms.maxSubArray3(ints));
    }
}
