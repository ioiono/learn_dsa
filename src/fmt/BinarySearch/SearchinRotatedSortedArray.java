package fmt.BinarySearch;

public class SearchinRotatedSortedArray {
    public int search3(int[] nums, int target) {
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

    public int search2(int[] nums, int target) {
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
            int mid = lo + (hi - lo) / 2;
            if (A[mid] == target) return mid;

            if (A[lo] <= A[mid]) {
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
        return -1;
    }

    public int searchTweak(int[] A, int target) {

        int lo = 0;
        int hi = A.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (A[mid] == target) return mid;

            if (A[lo] <= A[mid]) {
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
        return -1;
    }

    public int search4(int[] nums, int target) {
        return binarySearch(0, nums.length - 1, nums, target);
    }

    private int binarySearch(int start, int end, int[] nums, int target) {
        if (start > end) return -1;

        int mid = start + (end - start) / 2;

        // System.out.println(nums[mid]);

        if (target == nums[mid]) {
            return mid;
        } else if (nums[start] == nums[mid]) {
            return binarySearch(start + 1, end, nums, target);
            // first half is sorted
        } else if (nums[start] < nums[mid]) {
            if (target >= nums[start] && target < nums[mid]) {
                return binarySearch(start, mid - 1, nums, target);
            } else {
                return binarySearch(mid + 1, end, nums, target);
            }
            // second half is sorted
        } else {
            // since second half is increasing, if target is less than mid, it has to be in first half
            if (target > nums[mid] && target <= nums[end]) {
                return binarySearch(mid + 1, end, nums, target);
            } else {
                return binarySearch(start, mid - 1, nums, target);
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[]{13, 14, 15, 20, 30, 40, 50, 1, 3, 4, 5, 8, 9, 12};
        int[] ints2 = new int[]{3, 1};
        int[] ints3 = new int[]{4, 5, 6, 7, 0, 1, 2};

        SearchinRotatedSortedArray s = new SearchinRotatedSortedArray();

        System.out.println(s.search4(ints, 15));
        System.out.println(s.search3(ints, 15));
        System.out.println(s.search2(ints, 15));
        System.out.println(s.search(ints, 15));

        System.out.println(s.search4(ints2, 1));
        System.out.println(s.search3(ints2, 1));
        System.out.println(s.search2(ints2, 1));
        System.out.println(s.search(ints2, 1));

        System.out.println(s.search4(ints3, 1));
        System.out.println(s.search3(ints3, 1));
        System.out.println(s.search2(ints3, 1));
        System.out.println(s.search(ints3, 1));
    }
}
