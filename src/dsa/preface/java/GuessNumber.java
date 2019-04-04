package dsa.preface.java;

import java.util.Scanner;

public class GuessNumber {
    /**
     * x != y
     *
     * @param x two num both <= x
     * @param y sum of two >0 integer
     *
     * @return max times need to guess
     */
    public static int guess(int x, int y) {
        if (2 * x < y) {
            return 0;
        }
        int base = y / 2 + 1;
        int res = x - base + 1;

        if (x < y - 1) {
            return res;
        }
        // if x is max enough
        int res2 = y / 2;
        if (y % 2 == 0) {
            res2--;
        }

        return Math.min(res, res2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(guess(a, b));
        }
    }
}