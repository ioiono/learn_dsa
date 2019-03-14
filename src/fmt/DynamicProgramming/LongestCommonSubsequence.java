package fmt.DynamicProgramming;

public class LongestCommonSubsequence {

    public int lengthOfLCS(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }

    /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
    private int lcs(char[] X, char[] Y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (X[m - 1] == Y[n - 1])
            return 1 + lcs(X, Y, m - 1, n - 1);
        else
            return Math.max(lcs(X, Y, m, n - 1), lcs(X, Y, m - 1, n));
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();

        System.out.println(lcs.lengthOfLCS(new int[]{1, 2, 3}, new int[]{2, 3, 4}));

        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is: " + lcs.lcs(X, Y, m, n));
    }
}
