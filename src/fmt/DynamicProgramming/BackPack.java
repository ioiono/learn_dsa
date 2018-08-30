package fmt.DynamicProgramming;

import java.util.Arrays;

/**
 * Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?
 * <p>
 * Example If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5], so that the max
 * size we can fill this backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the
 * backpack.
 * <p>
 * You function should return the max size we can fill in the given backpack.
 * <p>
 * Challenge O(n x m) time and O(m) memory.
 * <p>
 * O(n x m) memory is also acceptable if you do not know how to optimize memory.
 * <p>
 * Notice You can not divide any item into small pieces.
 */
public class BackPack {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     *
     * @return: The maximum v
     */
    public int backPack(int m, int[] A) {
        int[] dp = new int[m + 1];
        for (int size : A) {
            for (int j = m; j > 0; j--) { // reverse to choose element only once
                if (j >= size) dp[j] = Math.max(dp[j], dp[j - size] + size);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[m];
    }

    public int backPack2(int m, int[] A) { // each item has an infinite number available
        int[] dp = new int[m + 1];
        for (int size : A) {
            for (int j = 1; j <= m; j++) {
                if (j >= size) dp[j] = Math.max(dp[j], dp[j - size] + size);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[m];
    }

    /**
     * Given n items with size A[i] and value V[i], and a backpack with size m. What's the maximum value can you put
     * into the backpack?
     *
     * @param m
     * @param A
     * @param V
     *
     * @return
     */
    public int backPackII(int m, int[] A, int V[]) { // with value
        int[] dp = new int[m + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = m; j > 0; j--) {
                if (j >= A[i]) dp[j] = Math.max(dp[j], dp[j - A[i]] + V[i]);
            }
        }
        return dp[m];
    }

    /**
     * Given n kind of items with size Ai and value Vi( each item has an infinite number available) and a backpack with
     * size m. What's the maximum value can you put into the backpack?
     *
     * @param A
     * @param V
     * @param m
     *
     * @return
     */
    public int backPackIII(int[] A, int[] V, int m) {
        int[] dp = new int[m + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = 1; j <= m; j++) {
                if (j >= A[i]) dp[j] = Math.max(dp[j], dp[j - A[i]] + V[i]);
            }
        }
        return dp[m];
    }

    /**
     * Given n items with size nums[i] which an integer array and all positive numbers, no duplicates. An integer target
     * denotes the size of a backpack. Find the number of possible fill the backpack.
     * <p>
     * Each item may be chosen unlimited number of times
     *
     * @param nums
     * @param target
     *
     * @return
     */
    public int backPackIV(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i] == j) dp[j]++;
                else if (nums[i] < j) dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }

    /**
     * Given n items with size nums[i] which an integer array and all positive numbers. An integer target denotes the
     * size of a backpack. Find the number of possible fill the backpack.
     * <p>
     * Each item may only be used once
     *
     * @param nums
     * @param target
     *
     * @return
     */
    public int backPackV(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= 0; j--) {
                if (j >= nums[i]) dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }

    /**
     * Given an integer array nums with all positive numbers and no duplicates, find the number of possible combinations
     * that add up to a positive integer target.
     * <p>
     * The different sequences are counted as different combinations.
     *
     * @param nums
     * @param target
     *
     * @return
     */
    // like to coinChange...
    public int backPackVI(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] A = new int[]{2, 3, 5, 7};
        BackPack bp = new BackPack();
        System.out.println(bp.backPack(11, A));
        System.out.println(bp.backPack(12, A));
        System.out.println(bp.backPack2(11, A));
        System.out.println(bp.backPack2(12, A));
    }
}
