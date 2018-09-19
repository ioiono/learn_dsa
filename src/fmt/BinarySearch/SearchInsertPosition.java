package fmt.BinarySearch;

public class SearchInsertPosition {
    // O(lgN)
    // PS:  not working if there are dups in the array!!
    public int searchInsert(int[] A, int target) {
        int lo = 0;
        int hi = A.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    // WORKING EVEN THERE ARE DUPS!
    public int searchInsert2(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    public int searchInsert3(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        // Invariant: the desired index is between [low, high+1]
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        // (1) At this point, low > high. That is, low >= high+1
        // (2) From the invariant, we know that the index is between [low, high+1], so low <= high+1. Follwing from (1), now we know low == high+1.
        // (3) Following from (2), the index is between [low, high+1] = [low, low], which means that low is the desired index
        //     Therefore, we return low as the answer. You can also return high+1 as the result, since low == high+1
        return low; // low == high + 1
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 3, 5, 6};
        int[] dups = new int[]{5, 7, 7, 8, 8, 10};

        SearchInsertPosition sip = new SearchInsertPosition();
        System.out.println(sip.searchInsert(A, 7));
        System.out.println(sip.searchInsert(A, 0));
        System.out.println(sip.searchInsert(A, 5));

        System.out.println(sip.searchInsert(dups, 8)); // wrong ans
        System.out.println(sip.searchInsert2(dups, 8));
        System.out.println(sip.searchInsert3(dups, 8));
    }
}
