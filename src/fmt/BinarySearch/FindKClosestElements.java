package fmt.BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        arr.sort((a, b) -> a.equals(b) ? a - b : Math.abs(a - x) - Math.abs(b - x));
        arr = arr.subList(0, k);
        Collections.sort(arr);
        return arr;
    }

    public List<Integer> findClosestElementsII(List<Integer> arr, int k, int x) {
        int lo = 0, hi = arr.size() - k;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (x - arr.get(mid) > arr.get(mid + k) - x)
                lo = mid + 1;
            else
                hi = mid;
        }
        return arr.subList(lo, lo + k);
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //-------- Main idea behind the binary search algorithm ----------//
        // 1) res will be a consecutive subarray of k size
        // 2) say if we need to pick 4 elems, now we r looking at 5 elem n1, n2, n3, n4, n5
        //    we need to compare two ends: diff(x, n1) and diff(x, n5), the number with bigger diff on the end will be eleminated
        //----------------------------------------------------------------//
        // lo and hi: range of all possible start of subarray with size k + 1, so we could compare both ends
        int lo = 0, hi = arr.length - k - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            // for subarray starting at mid with size k+1, we compare element of two ends to eliminate the loser
            if (Math.abs(x - arr[mid]) > Math.abs(x - arr[mid + k])) {
                lo = mid + 1; // arr[mid] is the one further away from x, eliminate range[lo, mid]
            } else {
                hi = mid - 1; // arr[mid+k] is the one further away, all [mid, hi] will have simiar situation, elimiate them
            }
        }
        // return subarray
        List<Integer> res = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            res.add(arr[lo + i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 1, 2, 3, 3, 3, 4, 6, 8, 8};
        FindKClosestElements k = new FindKClosestElements();
        System.out.println(k.findClosestElements(ints, 6, 1));

    }
}
