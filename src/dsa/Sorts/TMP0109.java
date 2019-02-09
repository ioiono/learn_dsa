package dsa.Sorts;

import java.util.Arrays;

public class TMP0109 {
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pIndex = partition(arr, start, end);
        quickSort(arr, start, pIndex - 1);
        quickSort(arr, pIndex + 1, end);
    }

    private int partition(int[] arr, int start, int end) {
        int pIndex = start;
        int pivot = arr[end];

        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                this.swap(arr, i, pIndex++);
            }
        }
        this.swap(arr, end, pIndex);
        return pIndex;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] test = Utils.genRands(10000, 1_000_000);
        System.out.println(Arrays.toString(test));
        new TMP0109().sort(test);
        System.out.println(Arrays.toString(test));
        Utils.test(test);
    }
}
