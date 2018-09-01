package fmt.DynamicProgramming;

import java.util.Arrays;


public class LongestIncreasingSubsequence {
    // O(N^2)
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = dp[0];
        for (int d : dp) {
            max = Math.max(d, max);
        }
        return max;
    }

    // O(NlgN)
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int length = 0;
        for (int n : nums) {
            int i = 0, j = length;
            while (i != j) {
                int mid = (i + j) / 2;
                if (dp[mid] < n) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            dp[i] = n;
            if (i == length) {
                length++;
            }
        }
        return length;
    }
    public int lengthOfLIS3(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));
    }
}
