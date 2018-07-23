package dsa.preface;

public class Reverse {
    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static void reverseRec(int[] arr, int lo, int hi) {
        if (lo < hi) {
            swap(arr, lo, hi);
            reverse(arr, lo + 1, hi - 1);
        }
    } //O(hi - lo +1)

    /**
     * 实际上， 属于尾递归形式的算法，均可以简捷地转换为等效的迭代版本。
     * 首先在起始位置插入一 个跳转标志next，然后将尾递归语句调用替换为一条指向next标志的跳转语句。
     */

    private static void reverse(int[] arr, int lo, int hi) {
        while (lo < hi) swap(arr, lo++, hi--);
    } //O(hi - lo + 1)

    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 4};
        Reverse.reverseRec(ints, 0, ints.length - 1);
        for (int el :
                ints) {
            System.out.print(el + ", ");
        }
        System.out.println();
        Reverse.reverse(ints, 0, ints.length - 1);
        for (int el :
                ints) {
            System.out.print(el + ", ");
        }

    }
}
