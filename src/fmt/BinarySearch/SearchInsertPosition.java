package fmt.BinarySearch;

public class SearchInsertPosition {
    // O(lgN)
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
        System.out.println(lo+","+hi);
        return lo;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 3, 5, 6};

        SearchInsertPosition sip = new SearchInsertPosition();
        System.out.println(sip.searchInsert(A, 7));
        System.out.println(sip.searchInsert(A, 0));
    }
}
