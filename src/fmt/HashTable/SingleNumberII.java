package fmt.HashTable;

/**
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once.
 * Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,3,2] Output: 3 Example 2:
 * <p>
 * Input: [0,1,0,1,0,1,99] Output: 99
 */

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }

}
