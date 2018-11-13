package dsa.Sorts;


import java.util.Arrays;

/**
 * Problem:Quick Sort, not stable
 * <p>
 * Time Complexity: O(NlogN) for average, O(N^2) for worst case.
 * <p>
 * Space Complexity: O(logN)
 */
public class QuickSort {

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Always pick last element as pivot
    public int partition(int[] a, int start, int end) {
        int partitionIndex = start;

        int pivot = a[end];
        for (int i = start; i < end; i++) {
            if (a[i] <= pivot) {
                swap(a, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(a, partitionIndex, end);
        return partitionIndex;
    }

    public void quickSort(int[] a, int start, int end) {
        if (start < end) {
            int pIndex = partition(a, start, end);
            quickSort(a, start, pIndex - 1);
            quickSort(a, pIndex + 1, end);
        }
    }

    public void sort(int[] nums) {
        this.quickSort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int[] nums = {-9, 4, -1, 3, 2, 1, 12, 4, 5, 3};
        q.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}