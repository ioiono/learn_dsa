package dsa.preface;

public class Fib {
    /*
     * 实际上，该算法需要运行O(2n)时间才能 计算出第n个Fibonacci数。这一指数复杂度的算法，在实际环境中毫无价值。
     */
    private static int fib(int n) {
        return (n < 2) ? n : fib(n - 1) + fib(n - 2);
    }

    // trick
    public static double getFibonacci(int n) {
        double f1 = Math.pow(((1 + Math.sqrt(5)) / 2.0), n);
        double f2 = Math.pow(((1 - Math.sqrt(5)) / 2.0), n);

        return Math.floor((f1 - f2) / Math.sqrt(5));
    }

    /**
     * 这里仅使用了两个中间变量f和g，记录当前的一对相邻Fibonacci数。整个算法仅需线性步的迭代，时间复杂度为O(n)。
     * 更重要的是，该版本仅需常数规模的附加空间，空间效率也有了 极大提高。
     * @param n [n]th fib
     * @return nth fib
     */
    private static long fibDP(int n) {
        long f = 0;
        long g = 1;
        while (n--> 0) {
            g = g + f;
            f = g - f;
        }
        return f;  // 0 1 1 2 3 5...
        // return g;  1 1 2 3 5 for climbing stairs from 1 or 2 steps.
    }

    public static void main(String[] args) {
        System.out.println(fib(3));
        System.out.println(fibDP(40));
        System.out.println(getFibonacci(100));
    }
}
