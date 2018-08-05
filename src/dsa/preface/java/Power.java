package dsa.preface.java;

public class Power {
    private static int power1(int n) {  //幂函数2^n算法(蛮力迭代版)，n >= 0
        int pow = 1;
        while (0 < n--) {
            pow <<= 1;
        }
        return pow;
    } //O(n) = O(2^r)，r为输入指数n比特位数

    private static int sqr(int a) {
        return a * a;
    }

    private static int power2(int n) {
        if (n == 0) { //递归基;
            return 1;
        }
        return 1 == (n & 1) ?
                sqr(power2(n >> 1)) << 1 : //然而并不能TCO...
                sqr(power2(n >> 1));
    } //O(log(n)) = O(r)，r为输入指数n比特位数，与蛮力版本的O(n) = O(2r)相比，计算效率得到了极大􏰊提高
    //(2^r = n)

    private static int power2(int a, int n) {
        if (n == 0) { //递归基;
            return 1;
        }
        return 1 == (n & 1) ?
                sqr(power2(n >> 1)) * a : //然而并不能TCO...
                sqr(power2(n >> 1));
    }

    private static int power3(int a, int b) {
        int r = 1;
        int base = a;
        while (b != 0) {
            if (1 == (b & 1)) {
                r *= base;
            }
            base *= base;
            b /= 2;
        }
        return r;
    } //O(log(b))

    private static double power3(double a, int b) {


        if (b < 0) {
            b = -b;
            a = 1 / a;
        }

        double r = 1;
        double base = a;

        while (b != 0) {
            if (1 == (b & 1)) {
                r *= base;
            }
            base *= base;
            b /= 2;
        }
        return r;
    } //O(log(b))

    public static void main(String[] args) {
        System.out.println(power1(20));
        System.out.println(power2(20));
        System.out.println(power2(2, 20));
        System.out.println(power3(2, 20));
        System.out.println(power3(2, 10));
        System.out.println(power3(2.0, -2));
    }
}
