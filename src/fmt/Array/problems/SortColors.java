package fmt.Array.problems;

import java.util.Arrays;

public class SortColors {
    // two pass
    public void sortColors(int[] nums) {
        int zeros = 0;
        int ones = 0;
        for (int num : nums) {
            if (num == 0) {
                zeros++;
            } else if (num == 1) {
                ones++;
            }
        }
        System.out.println(ones);
        for (int i = 0; i < nums.length; i++) {
            if (i < zeros) {
                nums[i] = 0;
            } else if (i < zeros + ones) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }

    // one pass
    public void sortColors2(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        // put 0 to left, 1 continue;, 2 to right
        while (index <= right) {
            if (nums[index] == 0) {
                swap(nums, index++, left++);
            } else if (nums[index] == 1) {
                index++;
            } else {
                swap(nums, index, right--);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{2, 0, 2, 1, 1, 0, 0};
        new SortColors().sortColors2(ints);
        System.out.println(Arrays.toString(ints));
    }
}
