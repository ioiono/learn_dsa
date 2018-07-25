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
        if (n == 0) { //递归基;否则，规n癿奇偶分删逑弻
            return 1;
        }
        return 1 == (n & 1) ? sqr(power2(n >> 1)) << 1 : sqr(power2(n >> 1));
    } //O(logn) = O(r)，r为输入指数n比特位数，与蛮力版本的O(n) = O(2r)相比，计算效率得到了极大􏰊高


    public static void main(String[] args) {
        System.out.println(power1(20));
        System.out.println(power2(20));
    }
}
