package dsa.Sorts;


import java.util.Arrays;

public class TMP1209 {
    public void sort(int[] arr, int start, int end) {
        if (start >= end) return;
        int pIndex = this.partition(arr, start, end);
        sort(arr, start, pIndex - 1);
        sort(arr, pIndex + 1, end);
    }

    private int partition(int[] arr, int start, int end) {
        int pIndex = start;
        int pivot = arr[end];
        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                this.swap(arr, pIndex++, i);
            }
        }
        this.swap(arr, pIndex, end);
        return pIndex;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = Utils.genRands(1000, 1000);
        Utils.test(arr);
        new TMP1209().sort(arr, 0, arr.length - 1);
        Utils.test(arr);
        System.out.println(Arrays.toString(arr));
    }

}
