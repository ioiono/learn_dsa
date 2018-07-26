package fmt.string.problems;

import java.util.Arrays;

public class TwoSumII {
    //  Two Sum II - Input array is sorted
    private static int[] twoSumII(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] < target) {
                i++;
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] ints = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSumII(ints, 9)));
        System.out.println(Arrays.toString(twoSumII(ints, -1)));
    }
}
