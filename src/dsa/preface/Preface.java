package dsa.preface;

public class Preface {


    private static int countOnes(int n) {
        int ones = 0;
        while (n > 0) {
            ones += (1 & n);
            n >>= 1;
        }
        return ones;
    }

    private static int countOnes2(int n) {
        int ones = 0;
        while (n != 0) {
            // trick
            n &= (n - 1);
            ones++;
        }
        return ones;
    }

    private static String i2b(int n) {
        StringBuilder s = new StringBuilder();
        while (n > 0) {
            s.append(n % 2 != 1 ? 0 : 1);
            n /= 2;
        }
        // remember to reverse
        return s.reverse().toString();

    }

    private static String i2bRec(int n) {
        StringBuilder sb = new StringBuilder();
        return convert(n, sb);
    }

    private static String convert(int n, StringBuilder sb) {
        if (n > 0) {
            sb.append(n % 2);
            return convert(n >> 1, sb);
        } else {
            return sb.reverse().toString();
        }

    }

    public static void main(String[] args) {
        // Test case with 441 -> 6

        System.out.println(Integer.toBinaryString(441));
        System.out.println(i2b(441));
        System.out.println(i2bRec(441));
        System.out.println(countOnes(441));
        System.out.println(countOnes2(441));

        System.out.println("==================");


    }
}
