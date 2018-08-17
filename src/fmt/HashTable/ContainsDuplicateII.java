package fmt.HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicateII(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]); // 666 好法
            if (!set.add(nums[i])) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 1, 2, 3};
        ContainsDuplicateII dup = new ContainsDuplicateII();
        System.out.println(dup.containsNearbyDuplicate(ints, 2));
    }
}
