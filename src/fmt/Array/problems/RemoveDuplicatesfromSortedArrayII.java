package fmt.Array.problems;

public class RemoveDuplicatesfromSortedArrayII {
    // cool
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        int len = removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + ", ");
        }
    }
}
