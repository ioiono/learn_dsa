package fmt.BinarySearch;

public class BS {
    public int search(int[] nums, int target) {
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
        int[] ints = new int[]{1, 3, 4, 5, 8, 9, 12};
        System.out.println(new BS().search(ints, 9));
        System.out.println(new BS().searchRec(ints, 9));
    }
}
