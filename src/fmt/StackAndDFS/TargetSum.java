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

    public static void main(String[] args) {
        TargetSum ts = new TargetSum();
        System.out.println(ts.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
