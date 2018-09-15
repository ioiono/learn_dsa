package fmt.Array.problems;

import java.util.Arrays;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,0] Output: 3 Example 2:
 * <p>
 * Input: [3,4,-1,1] Output: 2 Example 3:
 * <p>
 * Input: [7,8,9,11,12] Output: 1 Note:
 * <p>
 * Your algorithm should run in O(n) time and uses constant extra space.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int[] arr = new int[nums.length + 1];

        for (int num : nums) {
            if (num >= 0 && num < arr.length) {
                arr[num] = -1;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != -1) {
                return i;
            }
        }

        return arr.length;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public int firstMissingPositive2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{3, 2, -1, 3, 8, 4, 4, 3, 9, 1};
        System.out.println(new FirstMissingPositive().firstMissingPositive(ints));
        System.out.println(new FirstMissingPositive().firstMissingPositive2(ints));

    }
}
