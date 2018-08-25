package fmt.DynamicProgramming;

public class MinCostClimbingStairs {
    // f[i] = cost[i] + min(f[i+1], f[i+2])
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    // dp[n] = min(dp(n-1)+cost[n-1], dp(n-2)+cost[n-2]
    // return dp[n]
    public int minCostClimbingStairsRec(int[] cost) {
        int[] mem = new int[cost.length + 1];
        return dp(cost.length, cost, mem);
    }

    private int dp(int i, int[] cost, int[] mem) {
        if (i <= 1) return 0;

        if (mem[i] > 0) return mem[i];
        return mem[i] = Math.min(cost[i - 1] + dp(i - 1, cost, mem),
                cost[i - 2] + dp(i - 2, cost, mem));
    }


    public static void main(String[] args) {
        MinCostClimbingStairs mcs = new MinCostClimbingStairs();
        System.out.println(mcs.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println(mcs.minCostClimbingStairs(new int[]{0, 0, 1, 1}));
        System.out.println(mcs.minCostClimbingStairsRec(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println(mcs.minCostClimbingStairsRec(new int[]{0, 0, 1, 1}));
    }
}
