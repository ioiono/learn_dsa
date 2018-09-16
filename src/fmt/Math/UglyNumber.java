package fmt.Math;

/**
 * Write a program to check whether a given number is an ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * <p>
 * Example 1:
 * <p>
 * Input: 6 Output: true Explanation: 6 = 2 × 3 Example 2:
 * <p>
 * Input: 8 Output: true Explanation: 8 = 2 × 2 × 2 Example 3:
 * <p>
 * Input: 14 Output: false Explanation: 14 is not ugly since it includes another prime factor 7.
 */
public class UglyNumber {
    public static boolean isUgly(int num) {
        if (num < 1) return false;
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 5 == 0) {
                num /= 5;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isUgly2(int num) {
        if (num <= 0) return false;
        int[] factors = new int[]{2, 3, 5};
        for (int factor : factors)
            while (num % factor == 0) num /= factor;

        return num == 1;
    }


    public static void main(String[] args) {
        System.out.println(isUgly(14));
        System.out.println(isUgly2(14));
        System.out.println(isUgly(6));
        System.out.println(isUgly2(6));
        System.out.println(isUgly(8));
        System.out.println(isUgly2(8));
    }
}
