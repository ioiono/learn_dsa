package fmt.Math;

import java.util.Arrays;

/**
 * This problem was asked by Uber.
 * <p>
 * Given an array of integers, return a new array such that each element at index i of the new array is the product of
 * all the numbers in the original array except the one at i.
 * <p>
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was
 * [3, 2, 1], the expected output would be [2, 3, 6].
 */
public class OtherSum {
    // use division
    public int[] getSumNaive(int[] nums) {
        long pro = 1;
        for (int num : nums) {
            pro *= num;
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = (int) pro / nums[i];
        }
        return res;
    }

    // logb(xy) = logbx + logby
    // O(1) space
    public int[] getSum(int[] nums) {
        double pro = 0;
        for (int num : nums) {
            pro += Math.log(num);
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = (int) Math.round(Math.pow(Math.E, pro - Math.log(nums[i])));
        }
        return res;

    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        //The first iteration is to multiply the total on the left side of nums[i]
        //
        //The second iteration is to multiply the total on the right side of nums[i]
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int[] nums1 = new int[]{3, 2, 1};
        OtherSum os = new OtherSum();

        System.out.println(Arrays.toString(os.getSumNaive(nums)));
        System.out.println(Arrays.toString(os.getSumNaive(nums1)));
        System.out.println(Arrays.toString(os.getSum(nums)));
        System.out.println(Arrays.toString(os.getSum(nums1)));
        System.out.println(Arrays.toString(os.productExceptSelf(nums1)));
    }
}
