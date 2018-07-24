package fmt.array.problems;

public class FindPivotIndex {
    private static int pivotIndex(int[] nums) {
        // if sumL * 2==  sumTotal - num[i]; return i;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int sumLeft = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sumLeft * 2 == sum - nums[i]) {
                return i;
            }
            sumLeft += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 7, 3, 6, 5, 6};
        int[] arr2 = new int[]{1, 2,3};
        System.out.println(pivotIndex(arr));
        System.out.println(pivotIndex(arr2));
    }
}
