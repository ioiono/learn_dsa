package fmt.DynamicProgramming;

public class HouseRobberII {
    private int robRange(int[] nums, int lo, int hi) {

        int dp2 = 0;
        int dp1 = 0; // dp1 -> after go through first n houses, the max money you can get.
        for (int i = lo; i <= hi; i++) {
            int dp = Math.max(dp1, dp2 + nums[i]);
            dp2 = dp1;
            dp1 = dp;
        }
        return dp1;
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length - 1));
    }

    public static void main(String[] args) {
        int[] houses = new int[]{2, 7, 9, 3, 1};

        HouseRobberII hr = new HouseRobberII();
        System.out.println(hr.robRange(houses, 0, houses.length - 1));
    }
}
