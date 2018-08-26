package fmt.DynamicProgramming;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] g) {
        if (g == null || g.length == 0) return 0;
        int[] res = new int[g[0].length];
        res[0] = 1;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                if (g[i][j] == 1) {
                    res[j] = 0;
                } else if (j > 0) {
                    res[j] += res[j - 1];
                }
            }
        }
        return res[g[0].length - 1];
    }

    public static void main(String[] args) {

    }
}
