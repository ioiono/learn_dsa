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
        if (start >= end) return;
        int pIndex = partition(a, start, end);
        quickSort(a, start, pIndex - 1);
        quickSort(a, pIndex + 1, end);
    }

    /* A[] --> Array to be sorted,
   start  --> Starting index,
   end  --> Ending index */
    private void quickSortIterative(int arr[], int start, int end) {

        // Create an auxiliary stack
        int[] stack = new int[end - start + 1];

        // initialize top of stack
        int top = -1;

        // push initial values of start and end to stack
        stack[++top] = start;
        stack[++top] = end;

        // Keep popping from stack while is not empty
        while (top >= 0) {
            // Pop end and start
            end = stack[top--];
            start = stack[top--];

            // Set pivot element at its correct position
            // in sorted array
            int pIndex = partition(arr, start, end);

            // If there are elements on left side of pivot,
            // then push left side to stack
            if (pIndex - 1 > start) {
                stack[++top] = start;
                stack[++top] = pIndex - 1;
            }

            // If there are elements on right side of pivot,
            // then push right side to stack
            if (pIndex + 1 < end) {
                stack[++top] = pIndex + 1;
                stack[++top] = end;
            }
        }
    }

    public void sort(int[] nums) {
        this.quickSort(nums, 0, nums.length - 1);
    }

    public void sort2(int[] nums) {
        this.quickSortIterative(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int[] nums = {-9, 4, -1, 3, 2, 1, 12, 4, 5, 3};
        int[] nums2 = nums.clone();
        q.sort(nums);
        q.sort2(nums2);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums2));

    }
}