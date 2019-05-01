package fmt.Array.problems;

/**
 * This problem was asked by Amazon.
 * <p>
 * Given a sorted array, find the smallest positive integer that is not the sum of a subset of the array.
 * <p>
 * For example, for the input [1, 2, 3, 10], you should return 7.
 * <p>
 * Do this in O(N) time.
 *
 * Trick one...
 */
public class DailyCode224 {
    public int smallest(int[] nums) {
        int res = 1; // Initialize result
        // Traverse the array and increment 'res' if arr[i] is
        // smaller than or equal to 'res'.
        for (int i = 0; i < nums.length && nums[i] <= res; i++)
            res = res + nums[i];

        return res;
    }

    public static void main(String[] args) {
        DailyCode224 dc = new DailyCode224();
        System.out.println(dc.smallest(new int[]{1, 2, 3, 10}));

    }
}
