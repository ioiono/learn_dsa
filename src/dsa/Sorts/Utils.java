package dsa.Sorts;

import java.util.Arrays;

public class Utils {
    static int[] genRands(int size, int range) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * range);
        }
        return arr;
    }
    static void test(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                System.out.println("NO!");
                return;
            }
        }
        System.out.println("YES!");
    }

}
