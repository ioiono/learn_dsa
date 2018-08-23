package fmt.DynamicProgramming;

public class MinimumPathSum {
    private int[][] mem;

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        this.mem = new int[m][n];
        return minSum(grid, m - 1, n - 1);
    }

    private int minSum(int[][] grid, int x, int y) {
        if (x == 0 && y == 0) return grid[0][0];
        if (x < 0 || y < 0) return Integer.MAX_VALUE;
        if (mem[x][y] > 0) return mem[x][y];
        int ans = grid[x][y] + Math.min(minSum(grid, x - 1, y), minSum(grid, x, y - 1));
        return mem[x][y] = ans;
    }


    public int minPathSumDP(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j != 0) grid[i][j] += grid[i][j - 1];
                if (i != 0 && j == 0) grid[i][j] += grid[i - 1][j];
                if (i != 0 && j != 0) {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] mn = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        MinimumPathSum mp = new MinimumPathSum();
        System.out.println(mp.minPathSum(mn));
    }
}