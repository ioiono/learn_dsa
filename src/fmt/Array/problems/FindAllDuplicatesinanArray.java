package fmt.Array.problems;

import fmt.BinarySearch.FindKClosestElements;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements that appear twice in this array.
 *
 * Could you do it without extra space and in O(n) runtime?
 *
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [2,3]
 */
public class FindAllDuplicatesinanArray {
    public List<Integer> findDuplicates(int[] nums) {

        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set2.add(num);
            }
        }
        return new ArrayList<>(set2);
    }

    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                res.add(Math.abs(index + 1));
            nums[index] = -nums[index];
        }
        return res;
    }
    public List<Integer> findDuplicates3(int[] nums) {
        boolean[] existed = new boolean[nums.length + 1];
        List<Integer> res = new ArrayList<>();
        for (int n : nums) {
            if (existed[n])
                res.add(n);
            else
                existed[n] = true;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        FindAllDuplicatesinanArray f = new FindAllDuplicatesinanArray();
        System.out.println(f.findDuplicates(nums));
    }
}
