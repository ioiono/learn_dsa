package fmt.Array.problems;

public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        double res = Integer.MIN_VALUE;
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        res = Math.max(sum / k, res);
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            res = Math.max(sum / k, res);
        }

        return res;
    }

}
