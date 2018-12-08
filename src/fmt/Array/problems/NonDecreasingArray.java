package fmt.Array.problems;

public class NonDecreasingArray {
    private boolean sorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // N^2
    public boolean checkPossibility(int[] nums) {
        if (sorted(nums)) return true;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i - 1];
            if (nums[i] < nums[i - 1]) {
                nums[i - 1] = nums[i];
                if (sorted(nums)) {
                    return true;
                }
            }
            nums[i - 1] = cur; // recover it
        }

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (nums[i] < nums[i - 1]) {
                nums[i] = nums[i - 1];
                if (sorted(nums)) {
                    return true;
                }
            }
            nums[i] = cur; // recover it
        }
        return false;
    }

    // This problem is like a greedy problem. When you find nums[i-1] > nums[i] for some i, you will prefer to change
    // nums[i-1]'s value, since a larger nums[i] will give you more risks that you get inversion errors after
    // position i. But, if you also find nums[i-2] > nums[i], then you have to change nums[i]'s value instead, or
    // else you need to change both of nums[i-2]'s and nums[i-1]'s values.
    public boolean checkPossibility2(int[] nums) {
        int cnt = 0;                                                                    //the number of changes
        for (int i = 1; i < nums.length && cnt <= 1; i++) {
            if (nums[i - 1] > nums[i]) {
                cnt++;
                if (i - 2 < 0 || nums[i - 2] <= nums[i])
                    nums[i - 1] = nums[i];                    //modify nums[i-1] of a priority
                else nums[i] = nums[i - 1];                                                //have to modify nums[i]
            }
        }
        return cnt <= 1;
    }

    public static void main(String[] args) {
        NonDecreasingArray n = new NonDecreasingArray();

        System.out.println(n.checkPossibility(new int[]{4, 2, 3}));
        System.out.println(n.checkPossibility(new int[]{4, 2, 1}));
        System.out.println(n.checkPossibility(new int[]{1}));
        System.out.println(n.checkPossibility(new int[]{2, 3, 3, 2, 4}));
    }
}
