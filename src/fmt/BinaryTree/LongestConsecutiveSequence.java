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

    public int longestConsecutive2(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int maxLen = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            int count = 1;
            int same = 0;
            while (i < nums.length - 1 && (nums[i + 1] == nums[i] + 1 || nums[i + 1] == nums[i])) {
                if (nums[i + 1] == nums[i]) same++;
                count++;
                i++;
            }
            maxLen = Math.max(maxLen, count - same);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(ints));
        System.out.println(new LongestConsecutiveSequence().longestConsecutive2(ints));
    }
}
