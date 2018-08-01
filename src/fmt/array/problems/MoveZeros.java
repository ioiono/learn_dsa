package fmt.array.problems;

import java.util.Arrays;

public class MoveZeros {
    /**
     * trick
     * @param nums
     */
    private static void moveZeroes(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[idx++] = nums[i];
            }
        }
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }

    public void moveZeroes3(int[] nums) {
        int leftMostZeroIndex = 0; // The index of the leftmost zero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > leftMostZeroIndex) { // There are zero(s) on the left side of the current non-zero number, swap!
                    nums[leftMostZeroIndex] = nums[i];
                    nums[i] = 0;
                }

                leftMostZeroIndex++;
            }
        }
    }

    /**
     * more scalable solution by change the if condition to nums[i] > 2 or specific value
     *
     * @param nums array
     */
    private static void moveZeroes2(int[] nums) {

        int j = 0; // The index of the leftmost zero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) { // optimization
                    // actually nums[j] is 0, could do it without temp.
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
                j++;
            }
        }
    }

    // naive solution...
    static void test(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        int tmp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = tmp;
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 0, 2, 3, 0, 1, 0, 3, 12};
        moveZeroes2(ints);
        System.out.println(Arrays.toString(ints));
    }
}
