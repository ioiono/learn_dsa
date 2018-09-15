package fmt.Array.problems;

public class MissingNumber {
    // beats 100% XD
    public int missingNumber(int[] nums) {
        int n = nums.length;
        long sum = (n + 1) * n / 2;
        for (int num : nums) {
            sum -= num;
        }
        return (int) sum;
    }

    // better..
    public int missingNumber2(int[] nums) {
        int sum = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum += i;
            sum -= nums[i - 1];
        }

        return sum;

    }
}
