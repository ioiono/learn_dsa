package fmt.BinarySearch;

public class SearchinRotatedSortedArray {
    public int searchIII(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lo = 0;
        int hi = nums.length - 1;

        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;
            if (nums[mid] == target) return mid;
            if (nums[lo] < nums[mid]) { //left side
                if (nums[lo] <= target && target <= nums[mid]) {
                    hi = mid;
                } else lo = mid;
            } else {
                if (nums[mid] <= target && target <= nums[hi]) {
                    lo = mid;
                } else hi = mid;
            }

        }
        if (nums[lo] == target) return lo;
        if (nums[hi] == target) return hi;
        return -1;
    }

    public int searchII(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo == hi && nums[lo] == target ? lo : -1;
    }

    public int search(int[] A, int target) {
        int lo = 0;
        int hi = A.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (A[mid] == target) return mid;

            if (A[lo] <= A[mid]) {
                if (target >= A[lo] && target < A[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > A[mid] && target <= A[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{13, 14, 15, 20, 30, 40, 50, 1, 3, 4, 5, 8, 9, 12};
        int[] ints2 = new int[]{3, 1};
        int[] ints3 = new int[]{4, 5, 6, 7, 0, 1, 2};
        SearchinRotatedSortedArray s = new SearchinRotatedSortedArray();
        System.out.println(s.searchIII(ints, 15));
        System.out.println(s.searchII(ints, 15));
        System.out.println(s.search(ints, 15));

        System.out.println(s.searchIII(ints2, 1));
        System.out.println(s.searchII(ints2, 1));
        System.out.println(s.search(ints2, 1));

        System.out.println(s.searchIII(ints3, 1));
        System.out.println(s.searchII(ints3, 1));
        System.out.println(s.search(ints3, 1));
    }
}
