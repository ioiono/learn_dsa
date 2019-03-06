package fmt.Math;
// https://leetcode.com/articles/power-of-three/
public class PowerofThree {
    // my version
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        while (n % 3 == 0) {
            if (n == 3) return true;
            else n /= 3;
        }

        return false;
    }

    public boolean isPowerOfThree3(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }

    public boolean isPowerOfThree2(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int
        return (n > 0 && 1162261467 % n == 0);
    }

    public boolean isPowerOfThree4(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }

    // O(1)
    public boolean isPowerOfThree5(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {

    }
}
