package fmt.Math;

public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }
}
