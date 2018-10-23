package fmt.StackAndDFS;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        return dfs(nums, 0, S, 0);
    }

    private int dfs(int[] nums, int sum, int target, int k) {
        if (nums.length == k) return sum == target ? 1 : 0;
        return dfs(nums, sum + nums[k], target, k + 1) +
                dfs(nums, sum - nums[k], target, k + 1);
    }

    // DP
    // Runtime: 7 ms, faster than 100.00%.
    public int findTargetSumWaysDP(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
    }

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }

    public static void main(String[] args) {
        TargetSum ts = new TargetSum();
        System.out.println(ts.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(ts.findTargetSumWaysDP(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
