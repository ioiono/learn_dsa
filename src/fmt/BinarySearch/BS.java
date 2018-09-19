package fmt.BinarySearch;

public class BS {
    public int search(int[] nums, int target) {
        // [l, r]
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    // lower_bound
    public int search2(int[] nums, int target) {
        // [l, r)
        int l = 0;
        int r = nums.length;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return -1;
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
            if (nums[m] > target) { // find the smallest el that is bigger than the target
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    public int searchRec(int[] nums, int target) {
        return helper(nums, 0, nums.length - 1, target);
    }

    int helper(int[] nums, int lo, int hi, int target) {
        if (lo > hi) return -1;
        int mid = (lo + hi) >>> 1;
        if (nums[mid] < target) {
            return helper(nums, mid + 1, hi, target);
        } else if (nums[mid] > target) {
            return helper(nums, lo, mid - 1, target);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 2, 2, 4, 4, 5, 9, 9, 9, 12};
        System.out.println(new BS().searchLowerBound(ints, 2));
        System.out.println(new BS().searchUpperBound(ints, 2));
        System.out.println(new BS().search(ints, 2));
        System.out.println(new BS().search2(ints, 2));
        System.out.println(new BS().searchRec(ints, 2));
    }
}
