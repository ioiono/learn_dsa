package fmt.BinarySearch;

public class SearchinRotatedSortedArrayII {

    /**
     * 81. Search in Rotated Sorted Array II Follow up for "Search in Rotated Sorted Array": What if duplicates are
     * allowed?
     * <p>
     * 1 1 1 3 1
     * <p>
     * time : O(logn) (worst : O(n)) space : O(1);
     *
     * @param nums
     * @param target
     *
     * @return
     */

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) return true;
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
            } else if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) end = mid;
                else start = mid;
            } else {
                if (nums[mid] <= target && target <= nums[end]) start = mid;
                else end = mid;
            }
        }
        if (nums[start] == target) return true;
        return nums[end] == target;
    }

    public boolean search2(int[] A, int target) {

        int lo = 0;
        int hi = A.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (A[mid] == target) return true;
            if (A[mid] == A[lo] && A[mid] == A[hi - 1]) {
                lo++;
                hi--;
            } else if (A[lo] <= A[mid]) {
                if (A[lo] <= target && target <= A[mid]) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (A[mid] <= target && target <= A[hi - 1]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
        }
        return false;
    }

    public boolean search3(int[] A, int target) {

        int lo = 0;
        int hi = A.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (A[mid] == target) return true;
            if (A[mid] == A[lo] && A[mid] == A[hi]) {
                lo++;
                hi--;
            } else if (A[lo] <= A[mid]) {
                if (A[lo] <= target && target <= A[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (A[mid] <= target && target <= A[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return false;
    }

}
