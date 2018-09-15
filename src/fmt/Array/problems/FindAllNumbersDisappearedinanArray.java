package fmt.Array.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear
 * once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra
 * space.
 * <p>
 * Example:
 * <p>
 * Input: [4,3,2,7,8,2,3,1]
 * <p>
 * Output: [5,6]
 */
public class FindAllNumbersDisappearedinanArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        boolean[] arr = new boolean[nums.length];
        for (int n : nums) {
            arr[n - 1] = true;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(new FindAllNumbersDisappearedinanArray().findDisappearedNumbers(nums));

    }

}
