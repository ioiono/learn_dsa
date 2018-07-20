package dsa.preface;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sum {
    private static int sum(List<Integer> list) {
        int sum = 0;
        for (Integer el : list) {
            sum += el;
        }
        return sum;
    }

    private static int sum(int[] list) {
        int sum = 0;
        for (int el : list) {
            sum += el;
        }
        return sum;
    } //O(1) + O(n)*O(1) + O(1) = O(n+2) = O(n)


    private static int sumRec(List<Integer> list, int n) {
        if (n < 1) return 0;
        else return sumRec(list, n - 1) + list.get(n - 1);
    }

    private static int sumRec(int[] list, int n) {
        if (n < 1) return 0;
        else return sumRec(list, n - 1) + list[n - 1];
    } //O(1)* recursive depth = O(n + 1)*(1) = O(n)

    private static int sumRecTwoWay(int[] list, int lo, int hi) {
        if (lo == hi) {
            return list[lo];
        } else {
            int mi = lo + (hi - lo) / 2;
            return sumRecTwoWay(list, lo, mi) + sumRecTwoWay(list, mi + 1, hi);
        }
    } // O(hi - lo + 1) linear with length of range

    public static void main(String[] args) {
        int[] ints = new int[]{1, 3, 5, 3, 2, 0, 5};
        List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
        System.out.println(list);
        System.out.println(sum(list));
        System.out.println(sumRec(list, list.size()));
        System.out.println(sum(ints));
    }
}
