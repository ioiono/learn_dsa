package fmt.DynamicProgramming;

import java.util.Arrays;

public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;

        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] health = new int[m][n];

        health[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);

        for (int i = m - 2; i >= 0; i--) {
            health[i][n - 1] = Math.max(health[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }

        for (int j = n - 2; j >= 0; j--) {
            health[m - 1][j] = Math.max(health[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(health[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(health[i][j + 1] - dungeon[i][j], 1);
                health[i][j] = Math.min(right, down);
            }
        }
        System.out.println(Arrays.deepToString(health));
        return health[0][0];
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
        System.out.println(d.calculateMinimumHP(dungeon));
        System.out.println(d.calculateMinimumHP2(dungeon));
    }
}
