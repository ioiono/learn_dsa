package fmt.array.problems;

import java.util.Arrays;

public class RotateArray {

    private static void reverseArray(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        while (lo < hi) {
            int t = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = t;
            lo++;
            hi--;
        }
    }

    /**
     * Time complexity : O(n). n elements are reversed a total of three times.
     * <p>
     * Space complexity : O(1). No extra space is used.
     *
     * @param nums array
     * @param k    steps to rotate
     */
    private static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 4, 5, 6, 7,};
        System.out.println(Arrays.toString(ints));
        rotate(ints, 2);
        System.out.println(Arrays.toString(ints));
    }
}
