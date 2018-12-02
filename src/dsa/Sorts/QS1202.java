package dsa.Sorts;

import java.util.Arrays;

public class QS1202 {
    public void sort(int[] arr) {
        this.quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int pIndex = this.partition(arr, start, end);
        this.quickSort(arr, start, pIndex - 1);
        this.quickSort(arr, pIndex + 1, end);
    }

    private int partition(int[] arr, int start, int end) {
        int pIndex = start;
        int pivot = arr[end];

        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                this.swap(arr, i, pIndex);
                pIndex++;
            }
        }
        this.swap(arr, pIndex, end);
        return pIndex;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = Utils.genRands(1000, 1999);

        System.out.println(Arrays.toString(arr));
        new QS1202().sort(arr);
        System.out.println(Arrays.toString(arr));
        Utils.test(arr);
    }
}
