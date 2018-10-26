package fmt.DynamicProgramming;

import java.util.Arrays;

public class DungeonGame {
    public int calculateMinimumHP0(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) {
            return 1;
        }
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int[][] dp = new int[rows][cols];
        dp[rows - 1][cols - 1] = Math.max(1, 1 - dungeon[rows - 1][cols - 1]);

        for (int j = cols - 2; j >= 0; j--) {
            dp[rows - 1][j] = Math.max(1, dp[rows - 1][j + 1] - dungeon[rows - 1][j]);
        }

        for (int i = rows - 2; i >= 0; i--) {
            dp[i][cols - 1] = Math.max(1, dp[i + 1][cols - 1] - dungeon[i][cols - 1]);
        }

        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
            }
        }

        return dp[0][0];
    }

    public int calculateMinimumHP1(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;

        int m = dungeon.length;
        int n = dungeon[0].length;

        // hp[i][j]: min hp to reach i, j from bottom right of dungeon.
        int[][] hp = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                hp[i][j] = Integer.MAX_VALUE;
            }
        }

        hp[m][n - 1] = hp[m - 1][n] = 1;

        for (int j = n - 1; j >= 0; j--) {
            for (int i = m - 1; i >= 0; i--) {
                hp[i][j] = Math.max(1, Math.min(hp[i][j + 1], hp[i + 1][j]) - dungeon[i][j]);
            }
        }
        System.out.println(Arrays.deepToString(hp));
        return hp[0][0];
    }


    public int calculateMinimumHP2(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) {
            return 0;
        }
        int[][] memo = new int[dungeon.length][dungeon[0].length];
        return helper(dungeon, 0, 0, memo);
    }

    private int helper(int[][] dungeon, int i, int j, int[][] memo) {
        if (i >= dungeon.length || j >= dungeon[0].length) {
            return Integer.MAX_VALUE;
        }
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        int health = Integer.MAX_VALUE;
        health = Math.min(health, helper(dungeon, i + 1, j, memo));
        health = Math.min(health, helper(dungeon, i, j + 1, memo));
        health = health == Integer.MAX_VALUE ? 1 : health;
        int ans = health > dungeon[i][j] ? (health - dungeon[i][j]) : 1;
        memo[i][j] = ans;
        return ans;
    }

    public static void main(String[] args) {
        int[][] dungeon = new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5},
        };
        DungeonGame d = new DungeonGame();
        System.out.println(d.calculateMinimumHP0(dungeon));
        System.out.println(d.calculateMinimumHP1(dungeon));
        System.out.println(d.calculateMinimumHP2(dungeon));
    }
}
