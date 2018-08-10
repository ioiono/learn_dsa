package fmt.BinarySearch;

public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }

    /**
     *  O(log(n))
     * @param num
     * @return
     */
    public boolean isPerfectSquareII(int num) {
        int low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) >>> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }

    /**
     *  O(sqrt(n))
     * @param num
     * @return
     */
    public boolean isPerfectSquareIII(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }


    public static void main(String[] args) {
        IsPerfectSquare p = new IsPerfectSquare();
        System.out.println(p.isPerfectSquare(2147483647));
        System.out.println(p.isPerfectSquareII(2147483647));
        System.out.println(p.isPerfectSquareIII(2147483647));
        System.out.println(Integer.toBinaryString(0x7fffffff).length());
    }
}
