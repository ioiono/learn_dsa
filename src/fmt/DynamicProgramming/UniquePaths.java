package fmt.DynamicProgramming;

import java.util.Arrays;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            map[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            map[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }
        return map[m - 1][n - 1];
    }

    // time : O(n * m) space : O(n) actually could be O(min(n,m))
    public int uniquePaths2(int m, int n) {
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[j] += res[j - 1];
            }
        }
        System.out.println(Arrays.toString(res));
        return res[n - 1];
    }

    //Total permutations = (m+n)! / (m! * n!)
    public int uniquePathsMath(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        m--;
        n--;
        if (m < n) {              // Swap, so that m is the bigger number
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long res = 1;
        int j = 1;
        for (int i = m + 1; i <= m + n; i++, j++) {       // Instead of taking factorial, keep on multiply & divide
            res *= i;
            res /= j;
        }

        return (int) res;
    }

    public static void main(String[]  args) {
        System.out.println(new UniquePaths().uniquePaths(3, 3));
        System.out.println(new UniquePaths().uniquePaths2(4, 3));
        System.out.println(new UniquePaths().uniquePathsMath(3, 3));
    }
}
