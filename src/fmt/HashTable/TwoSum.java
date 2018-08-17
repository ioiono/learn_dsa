package fmt.HashTable;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] ints = new int[]{2, 7, 11, 15};
        TwoSum ts = new TwoSum();
        System.out.println(Arrays.toString(ts.twoSum(ints, 17)));
    }
}
