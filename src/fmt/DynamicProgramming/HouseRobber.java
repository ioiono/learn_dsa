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

    public int rob3(int[] nums) {
        if (nums.length == 0) return 0;

        int m0 = 0;
        int m1 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            int tmp = m1;
            m1 = Math.max(m1, m0 + val);
            m0 = tmp;
        }
        return m1;
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
