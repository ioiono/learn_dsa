package dsa.Sorts;

import java.util.Arrays;

public class QuickSortWhile {
    private int partition(int arr[], int left, int right) {

        int i = left, j = right;
        int pivot = arr[left + (right - left) / 2];

        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;

            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        return i;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void quickSort(int arr[], int left, int right) {
        if (left >= right) return;
        int index = partition(arr, left, right);
        quickSort(arr, left, index - 1);
        quickSort(arr, index, right);

    }

    public void sort(int[] arr) {
        this.quickSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        QuickSortWhile q = new QuickSortWhile();
        int[] nums = {-9, 4, -1, 3, 2, 1, 12, 4, 5, 3};
        q.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
