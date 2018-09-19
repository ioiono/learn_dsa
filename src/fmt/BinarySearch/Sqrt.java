package fmt.BinarySearch;

/**
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * <p>
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is
 * returned.
 */
public class Sqrt {
    public int mySqrt(int x) {
        int lo = 1;
        int hi = x;
        int res = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid > x / mid) {
                hi = mid - 1;
            } else {
                res = mid;
                lo = mid + 1;
            }
        }
        return res;
    }

    /**
     * Similar idea, a little cleaner implementation. I used the trick m=(l+r+1)/2, something I learned from others on
     * Leetcode, basically to tilt the mid calculations towards to the right (instead of to the left from integer
     * division flooring).
     *
     * @param x
     *
     * @return
     */
    int mySqrt2(int x) {
        int l = 0, r = x;
        while (l < r) {
            int m = (l + r + 1) / 2;
            if (m > x / m) r = m - 1;
            else l = m;
        }
        return r;
    }

    int sqrt2(int x) {
        long tmp = (long) x;
        long l = 0;
        long r = tmp + 1;
        while (l < r) {
            long m = l + (r - l) / 2;
            if (m * m > tmp) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return (int) (l - 1);
    }

    int sqrt(int x) {
        long r = x;
        while (r * r > x)
            r = (r + x / r) / 2;
        return (int) r;
    }


    public static void main(String[] args) {
        int n = 2147483647;
        System.out.println(new Sqrt().mySqrt(n));
        System.out.println(new Sqrt().mySqrt2(n));
        System.out.println(new Sqrt().sqrt(n));
        System.out.println(new Sqrt().sqrt2(n));
    }
}
