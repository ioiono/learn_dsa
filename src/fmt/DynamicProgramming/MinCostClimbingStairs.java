package fmt.DynamicProgramming;

public class MinCostClimbingStairs {
    // f[i] = cost[i] + min(f[i-1], f[i-2])
    public int minCostClimbingStairs(int[] cost) {
        // dp[i] : min cost before leaving i-th step, including cost[i] in dp[i]
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    public int minCostClimbingStairsDP(int[] costs) {
        int dp1 = 0;
        int dp2 = 0;
        for (int cost : costs) {
            int dp = Math.min(dp1, dp2) + cost;
            dp2 = dp1;
            dp1 = dp;
        }

        return Math.min(dp2, dp1);
    }

    public int minCostClimbingStairsDP2(int[] costs) {
        int dp1 = 0;
        int dp2 = 0;
        for (int i = 2; i <= costs.length; i++) {
            int dp = Math.min(dp1 + costs[i - 1], dp2 + costs[i - 2]);
            dp2 = dp1;
            dp1 = dp;
        }
        return dp1;
    }

    // emmm
    public int minCostClimbingStairs2(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] = Math.min(cost[i - 1], cost[i - 2]) + cost[i];
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }

    // dp[n] = min(dp(n-1)+cost[n-1], dp(n-2)+cost[n-2])
    // here dp[i] means min cost to climb to i-th step (exactly what the problem asks)
    public int minCostClimbingStairsRec(int[] cost) {
        int n = cost.length;
        int[] mem = new int[cost.length + 1];
        return dp(n, cost, mem);
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
        System.out.println(mcs.minCostClimbingStairsRec(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println(mcs.minCostClimbingStairsDP(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println(mcs.minCostClimbingStairs(new int[]{0, 0, 1, 1}));
        System.out.println(mcs.minCostClimbingStairsRec(new int[]{0, 0, 1, 1}));
        System.out.println(mcs.minCostClimbingStairsDP(new int[]{0, 0, 1, 1}));
    }
}
