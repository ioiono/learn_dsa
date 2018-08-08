package fmt.Array.problems;

public class RemoveDuplicatesfromSortedArray {
    private static int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        while (++j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }

        return i + 1;
    }

    private static int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = removeDuplicates(ints);
        for (int i = 0; i < len; i++) {
            System.out.print(ints[i] + ", ");
        }
    }
}
