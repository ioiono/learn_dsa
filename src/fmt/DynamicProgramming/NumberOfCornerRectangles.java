package fmt.DynamicProgramming;

public class NumberOfCornerRectangles {
    public int countCornerRectangles(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int cnt = 0;
                for (int k = 0; k < n; k++) {
                    if (grid[i][k] == 1 && grid[j][k] == 1) {
                        cnt++;
                    }
                }
                int res = cnt * (cnt - 1);
                count += res;
            }
        }

        return count;
    }

    public int countCornerRectanglesBF(int[][] grid) {
        int rst = 0;
        if (validate(grid)) return rst;
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) { // grid[i][j], starting point
                for (int h = i + 1; h < m; h++) { // pick right-end corner
                    for (int k = j + 1; k < n; k++) {
                        rst += validateRect(grid, i, j, h, k) ? 1 : 0;
                    }
                }
            }
        }
        return rst;
    }

    private boolean validateRect(int[][] grid, int i, int j, int h, int k) {
        return grid[i][j] == 1 && grid[h][k] == 1 && grid[i][k] == 1 && grid[h][j] == 1;
    }

    private boolean validate(int[][] grid) {
        return grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0;
    }
}
