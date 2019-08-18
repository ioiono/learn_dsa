package fmt.BinaryTree;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int res = 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        for (int num : nums) {
            if (!set.contains(num - 1)) { // left boundary
                int l = 0;
                while (set.contains(num++)) l++;
                res = Math.max(res, l);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(ints));
    }
}
