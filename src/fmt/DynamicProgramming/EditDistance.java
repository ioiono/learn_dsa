package fmt.DynamicProgramming;

import java.util.Arrays;

public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] cost = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            cost[i][0] = i;
        for (int i = 1; i <= n; i++)
            cost[0][i] = i;
        System.out.println(Arrays.deepToString(cost));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    cost[i + 1][j + 1] = cost[i][j];
                } else {
                    int add = cost[i][j + 1];
                    int del = cost[i + 1][j];
                    int rep = cost[i][j];
                    cost[i + 1][j + 1] = Math.min(Math.min(add, del), rep) + 1;
                }
            }
        }
        return cost[m][n];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }
}
