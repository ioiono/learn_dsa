package fmt.DynamicProgramming;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public boolean canPartition2D(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;

        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }

        dp[0][0] = true;

        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j < sum + 1; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = (dp[i][j] || dp[i - 1][j - nums[i - 1]]);
                }
            }
        }

        return dp[n][sum];
    }

    // clean code
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int half = sum / 2;
        int[] dp = new int[half + 1];
        for (int num : nums) {
            // or shorter XD.
            // for (int j = half; j >= num; j--) {
            //     dp[j] = Math.max(dp[j], dp[j - num] + num);
            // }
            for (int j = half; j > 0; j--) {
                if (j >= num) dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
        }
        return dp[half] * 2 == sum;
    }

    // clean code
    // Runtime: 19 ms, faster than 66.35%
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int half = sum / 2;
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;// true if target sum is 0
        for (int num : nums) {
            for (int i = half; i > 0; i--) {
                if (i >= num) dp[i] = (dp[i] || dp[i - num]);
            }
        }
        return dp[half];
    }

    // Runtime: 8 ms, faster than 90.86%
    public boolean canPartition3(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int half = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;// true if target sum is 0
        for (int num : nums) {
            for (int i = half; i >= 0; i--) {
                if (dp[i]) dp[i + num] = true;
            }
            if (dp[half]) return true;
        }
        return false;
    }

    public boolean canPartition4(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int half = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;// true if target sum is 0
        for (int num : nums) {
            for (int i = half; i >= num; i--) {
                if (dp[i - num]) dp[i] = true;
            }
            if (dp[half]) return true;
        }
        return false;
    }


    // dfs
    // Runtime: 7 ms, faster than 92.53%
    public boolean canPartitionDFS(int[] nums) {
        int sum = 0;
        for (int val : nums) {
            sum += val;
        }
        if (sum % 2 != 0) return false;
        sum = sum / 2;
        return dfs(nums, sum, 0); // whether we can find subset to total sum.
    }

    private boolean dfs(int[] nums, int target, int pos) {
        if (target == 0) return true;
        if (target < 0 || pos >= nums.length) return false;
        if (dfs(nums, target - nums[pos], pos + 1)) return true; // use the num at pos;
        int j = pos + 1;
        while (j < nums.length && nums[j] == nums[pos]) j++;
        return dfs(nums, target, j); // do not use num and any num that equals to num[pos].
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        int[] nums2 = new int[]{1, 2, 3, 5};
        System.out.println(new PartitionEqualSubsetSum().canPartition(nums));
        System.out.println(new PartitionEqualSubsetSum().canPartition2(nums));
        System.out.println(new PartitionEqualSubsetSum().canPartition3(nums));
        System.out.println(new PartitionEqualSubsetSum().canPartition4(nums));
        System.out.println(new PartitionEqualSubsetSum().canPartition2D(nums));
        System.out.println(new PartitionEqualSubsetSum().canPartitionDFS(nums));

        System.out.println(new PartitionEqualSubsetSum().canPartition(nums2));
        System.out.println(new PartitionEqualSubsetSum().canPartition2(nums2));
        System.out.println(new PartitionEqualSubsetSum().canPartition3(nums2));
        System.out.println(new PartitionEqualSubsetSum().canPartition4(nums2));
        System.out.println(new PartitionEqualSubsetSum().canPartition2D(nums2));
        System.out.println(new PartitionEqualSubsetSum().canPartitionDFS(nums2));
    }
}
