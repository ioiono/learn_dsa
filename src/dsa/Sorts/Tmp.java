package dsa.Sorts;


import java.util.Arrays;

public class Tmp {
    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
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
        this.swap(arr, end, pIndex);
        return pIndex;
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int pIndex = partition(arr, start, end);
        quickSort(arr, start, pIndex - 1);
        quickSort(arr, pIndex + 1, end);
    }

    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }


    public static void main(String[] args) {
        Tmp q = new Tmp();
        int[] nums = {0, 4, 3, 3, 3 - 9, 0, 4, -1, 3, 2, 1, 12, 4, 5, 3};
        q.sort(nums);
        System.out.println(Arrays.toString(nums));
        Utils.test(nums);
    }
}
