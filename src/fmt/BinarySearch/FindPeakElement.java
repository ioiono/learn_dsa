package fmt.BinarySearch;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if ((mid == 0 || nums[mid] >= nums[mid - 1]) &&
                    (mid == nums.length - 1 || nums[mid] >= nums[mid + 1])) {
                return mid;
            } else if (mid > 0 && nums[mid - 1] > nums[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }

    public int findPeakElement2(int[] A) {
        int lo = 0, hi = A.length;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            // Find the smallest l such that A[l] > A[l + 1].

            if (mi + 1 < A.length && A[mi] < A[mi + 1])
                lo = mi + 1;
            else
                hi = mi;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1};
        FindPeakElement fpe = new FindPeakElement();
        System.out.println(fpe.findPeakElement(arr));
    }
}
