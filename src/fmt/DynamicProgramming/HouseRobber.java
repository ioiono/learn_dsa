package fmt.DynamicProgramming;

import java.util.Arrays;

public class HouseRobber {
    public int rob0(int[] nums) {
        int a = 0;
        int b = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                a = Math.max(a + nums[i], b);
            } else {
                b = Math.max(a, b + nums[i]);
            }
        }

        return Math.max(a, b);
    }

    private int[] memo;

    public int rob1(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return rob(nums, nums.length - 1);
    }

    private int rob(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] >= 0) {
            return memo[i];
        }
        int result = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
        memo[i] = result;
        return result;
    }

    public int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            memo[i + 1] = Math.max(memo[i], memo[i - 1] + val);
        }
        return memo[nums.length];
    }
    // clean code XD
    public int rob3(int[] nums) {
        if (nums.length == 0) return 0;

        int dp2 = 0;
        int dp1 = 0; // dp1 -> after go through first n houses, the max money you can get.
        for (int num : nums) {
            int dp = Math.max(dp1, dp2 + num);
            dp2 = dp1;
            dp1 = dp;
        }
        return dp1;
    }

    public int rob4(int[] nums) {
        int prevNo = 0;
        int prevYes = 0;
        for (int n : nums) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = n + temp;
        }
        return Math.max(prevNo, prevYes);
    }

    public static void main(String[] args) {
        HouseRobber hb = new HouseRobber();
        int[] houses = new int[]{2, 7, 9, 3, 1};
        System.out.println(hb.rob0(houses));
        System.out.println(hb.rob1(houses));
        System.out.println(hb.rob2(houses));
        System.out.println(hb.rob3(houses));
        System.out.println(Arrays.toString(hb.memo));
    }
}
