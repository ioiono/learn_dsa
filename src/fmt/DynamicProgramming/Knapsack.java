package fmt.DynamicProgramming;

import java.util.Arrays;

public class Knapsack {
    /**
     * Given N items, w[i] is the weight of the i-th item and v[i] is value of the i-th item. Given a knapsack with
     * capacity W. Maximize the total value. Each item can be use 0 or 1 time.
     * <p>
     * 0-1背包问题的通常定义是：一共有N件物品，第i件物品的重量为w[i]，价值为v[i]。在总重量不超过背包承载上限W的情况下，能够获得的最大价值是多少？每件物品可以使用0次或者1次。
     * <p>
     * 例子：
     * <p>
     * 重量 w = [1, 1, 2, 2]
     * <p>
     * 价值 v = [1, 3, 4, 5]
     * <p>
     * 背包承重 W = 4
     * <p>
     * 最大价值为9，可以选第1,2,4件物品，也可以选第3，4件物品；总重量为4，总价值为9。
     * <p>
     * 动态规划的状态转移方程为：
     * <p>
     * 1 dp[i][j] = max(dp[i-1][j], dp[i][j-w[i]] + v[i])
     *
     * @param W backpack size
     * @param w weight of a item
     * @param v value of a item
     *
     * @return
     */
    public int knapsack(int W, int[] w, int[] v) {
        int N = w.length;
        int[][] dp = new int[N + 1][W + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = w[i - 1]; j <= W; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
            }
        }
        return dp[N][N];

    }

    public int knapsack2(int W, int[] w, int[] v) {
        int[] dp = new int[W + 1];

        for (int i = 0; i < w.length; i++) {
            for (int j = W; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j - 1], dp[j - w[i]] + v[i]);
            }
        }

        return dp[W];
    }

    public static void main(String[] args) {
        int[] w = new int[]{1, 1, 2, 2};
        int[] v = new int[]{1, 3, 4, 5};
        int W = 4;
        Knapsack k = new Knapsack();

        System.out.println(k.knapsack(W, w, v));
        System.out.println(k.knapsack2(W, w, v));
    }
}

