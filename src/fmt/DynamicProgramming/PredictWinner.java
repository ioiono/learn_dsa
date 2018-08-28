package fmt.DynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/predict-the-winner/solution/
public class PredictWinner {
    // O(2^n)
    public boolean PredictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length - 1) >= 0;
    }

    private int helper(int[] nums, int s, int e) {
        return s == e ? nums[e]
                : Math.max(nums[e] - helper(nums, s, e - 1),
                nums[s] - helper(nums, s + 1, e));
    }

    // with memoization
    private int[] m;

    public boolean predictTheWinner(int[] nums) {
        this.m = new int[nums.length * nums.length];
        return getScore(nums, 0, nums.length - 1) >= 0;
    }

    private int getScore(int[] nums, int l, int r) {
        if (l == r) return nums[l];
        int k = l * nums.length + r;
        if (m[k] > 0) return m[k];
        return m[k] = Math.max(nums[l] - getScore(nums, l + 1, r),
                nums[r] - getScore(nums, l, r - 1));
    }

    public boolean PredictTheWinnerDP2D(int[] nums) {
        //if (nums.length % 2 == 0) {
        //    return true;
        //}
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return dp[0][n - 1] >= 0;
    }

    public boolean PredictTheWinnerDP1D(int[] nums) {
        if (nums == null) {
            return true;
        }
        int n = nums.length;
        if ((n & 1) == 0) {
            return true;
        } // Improved with hot13399's comment.
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i] = nums[i];
                } else {
                    dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
                }
            }
        }
        return dp[n - 1] >= 0;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 2, 4, 6};
        PredictWinner winner = new PredictWinner();
        System.out.println(winner.PredictTheWinnerDP2D(nums));
    }


}
