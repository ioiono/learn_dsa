package fmt.DynamicProgramming;


/**
 * A string of '0's and '1's is monotone increasing if it consists of some number of '0's (possibly 0), followed by some
 * number of '1's (also possibly 0.)
 * <p>
 * We are given a string S of '0's and '1's, and we may flip any '0' to a '1' or a '1' to a '0'.
 * <p>
 * Return the minimum number of flips to make S monotone increasing. Example 1:
 * <p>
 * Input: "00110" Output: 1 Explanation: We flip the last digit to get 00111. Example 2:
 * <p>
 * Input: "010110" Output: 2 Explanation: We flip to get 011111, or alternatively 000111. Example 3:
 * <p>
 * Input: "00011000" Output: 2 Explanation: We flip to get 00000000.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= S.length <= 20000 S only consists of '0' and '1' characters.
 */
public class FlipStringtoMonotoneIncreasing {
    public int minFlipsMonoIncr(String S) {
        int N = S.length();
        int[] dp = new int[N + 1];
        for (int i = 0; i < N; ++i)
            dp[i + 1] = dp[i] + (S.charAt(i) == '1' ? 1 : 0);

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j <= N; ++j) {
            ans = Math.min(ans, dp[j] + N - j - (dp[N] - dp[j]));
        }

        return ans;
    }

    public static void main(String[] args) {
        FlipStringtoMonotoneIncreasing flip = new FlipStringtoMonotoneIncreasing();
        System.out.println(flip.minFlipsMonoIncr("010110"));
    }
}
