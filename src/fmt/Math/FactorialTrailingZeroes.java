package fmt.Math;

public class FactorialTrailingZeroes {

    // Runtime: 34 ms, faster than 5.67% XD
    // O(log_5N)
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    // Runtime: 11 ms, faster than 100.00% of Java online submissions for Factorial Trailing Zeroes.
    // O(log_5N)
    public int trailingZeroes2(int n) {
        int rs = 0;
        while (n > 0) {
            n /= 5;
            rs += n;
        }
        return rs;
    }

    public static void main(String[] args) {
        FactorialTrailingZeroes f = new FactorialTrailingZeroes();

        System.out.println(f.trailingZeroes(5));
        System.out.println(f.trailingZeroes2(5));
    }
}
