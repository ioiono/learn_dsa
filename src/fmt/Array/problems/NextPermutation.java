package fmt.Array.problems;

import java.util.Arrays;

public class NextPermutation {
    /**
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of
     * numbers.
     * <p>
     * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending
     * order).
     * <p>
     * The replacement must be in-place and use only constant extra memory.
     * <p>
     * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand
     * column.
     * <p>
     * 1,2,3 → 1,3,2 3,2,1 → 1,2,3 1,1,5 → 1,5,1
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int firstSmallIdx = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstSmallIdx = i;
                break;
            }
        }
        if (firstSmallIdx == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int firstLargeIdx = -1;

        for (int i = nums.length - 1; i > firstSmallIdx; i--) {
            if (nums[i] > nums[firstSmallIdx]) {
                firstLargeIdx = i;
                break;
            }
        }

        swap(nums, firstSmallIdx, firstLargeIdx);
        reverse(nums, firstSmallIdx + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 3, 2};
        new NextPermutation().nextPermutation(ints);
        System.out.println(Arrays.toString(ints));
    }
}
