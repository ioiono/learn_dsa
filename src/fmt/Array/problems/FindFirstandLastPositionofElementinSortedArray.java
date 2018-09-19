package fmt.Array.problems;

import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray {
    // lower-upper bound...
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;

        return targetRange;
    }

    // lower_bound
    public int searchLowerBound(int[] nums, int target) {
        // [l, r)
        int l = 0;
        int r = nums.length;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= target) { // find the smallest el that is bigger than or equal to the target
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    // upper_bound

    public int searchUpperBound(int[] nums, int target) {
        // [l, r)
        int l = 0;
        int r = nums.length;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > target) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    public int[] searchRange2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int l = searchLowerBound(nums, target);
        if (l >= nums.length || nums[l] != target) {
            return new int[]{-1, -1};
        }
        int r = searchUpperBound(nums, target) - 1;
        return new int[]{l, r};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        FindFirstandLastPositionofElementinSortedArray f = new FindFirstandLastPositionofElementinSortedArray();
        System.out.println(Arrays.toString(f.searchRange(nums, target)));

    }
}
