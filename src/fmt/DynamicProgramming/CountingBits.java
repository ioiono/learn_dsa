package fmt.DynamicProgramming;

import java.util.Arrays;

public class CountingBits {
    //  f[i] = f[i / 2] + i % 2.
    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i = 1; i <= num; i++)
            f[i] = f[i >> 1] + (i & 1);
        return f;
    }

    //  f[i] = f[i / 2] + i % 2.
    public int[] countBits2(int num) {
        int[] ret = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            ret[i] = ret[i & (i - 1)] + 1;
        return ret;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountingBits().countBits(10)));
    }
}
