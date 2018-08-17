package fmt.HashTable;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 2, 3, 4};
        int[] ints2 = new int[]{1, -1, 2, 3, 4};

        ContainsDuplicate dup = new ContainsDuplicate();
        System.out.println(dup.containsDuplicate(ints));
        System.out.println(dup.containsDuplicate(ints2));
    }
}
