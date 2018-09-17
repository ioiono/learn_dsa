package fmt.Array.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MajorityElement {

    // O(N) O(1) Boyer-Moore Majority Vote algorithm
    public int majorityElement(int[] nums) {

        int count = 0;
        int candidate = nums[0];

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    // Hash table O(n) / O(n)

    private Map<Integer, Integer> countNums(int[] nums) {

        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        return counts;
    }

    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }

    /**
     * Complexity Analysis
     * <p>
     * Time complexity : O(n^2)
     * <p>
     * The brute force algorithm contains two nested for loops that each run for nn iterations, adding up to quadratic
     * time complexity.
     * <p>
     * Space complexity : O(1)
     * <p>
     * The brute force solution does not allocate additional space proportional to the input size.
     *
     * @param nums
     *
     * @return
     */
    public int majorityElement3(int[] nums) {
        int majorityCount = nums.length / 2;

        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count += 1;
                }
            }

            if (count > majorityCount) {
                return num;
            }

        }

        return -1;
    }


    // sorting
    public int majorityElement4(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // rand
    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    public int majorityElement5(int[] nums) {
        Random rand = new Random();

        int majorityCount = nums.length / 2;

        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }

    // divide and conquer
    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    public int majorityElement6(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }


    // bit voting
    public int majorityElement7(int[] nums) {
        final int n = nums.length;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            int cnt = 0;
            for (final int num : nums) {
                if ((num & mask)!=0 && (++cnt > n / 2)) {
                    res |= mask;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        MajorityElement me = new MajorityElement();
        System.out.println(me.majorityElement(nums));
        System.out.println(me.majorityElement2(nums));
        System.out.println(me.majorityElement3(nums));
        System.out.println(me.majorityElement4(nums));
        System.out.println(me.majorityElement5(nums));
        System.out.println(me.majorityElement6(nums));
        System.out.println(me.majorityElement7(nums));
    }
}
