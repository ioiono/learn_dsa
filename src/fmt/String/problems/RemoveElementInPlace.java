package fmt.String.problems;

import java.util.Arrays;

public class RemoveElementInPlace {
    static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 2, 1};
        int len = removeElement(nums, 2);
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, len)));
    }

}
