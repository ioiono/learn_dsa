package fmt.BinarySearch;

public class DivideTwoIntegers {
    /**
     * Divide two integers without using multiplication, division and mod operator. 1, + - 2, 越界 3, = 0 3/5 4, 正常
     * <p>
     * time : O(logn) space : O(logn)
     *
     * @param dividend
     * @param divisor
     *
     * @return
     */
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) sign = -1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        if (ldividend < ldivisor || ldividend == 0) return 0;
        long lres = divide(ldividend, ldivisor);
        int res = 0;
        if (lres > Integer.MAX_VALUE) {
            res = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else res = (int) (sign * lres);
        return res;
    }

    public long divide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) return 0;
        long sum = ldivisor;
        long multiple = 1;
        while ((sum + sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + divide(ldividend - sum, ldivisor);
    }

    public int divide2(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        int flag = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            flag = -1;
        if (divisor > 0)
            divisor = -divisor;
        if (dividend > 0)
            dividend = -dividend;
        int result = 0;
        while (dividend <= divisor) {
            int count = 1, tempDivisor = divisor;
            while (dividend - tempDivisor <= tempDivisor) {
                count <<= 1;
                tempDivisor <<= 1;
            }
            result += count;
            dividend -= tempDivisor;
        }
        return flag * result;
    }

    public static void main(String[] args) {
        DivideTwoIntegers d = new DivideTwoIntegers();
        System.out.println(d.divide(10, 3));
        System.out.println(d.divide(7, -3));
        System.out.println(d.divide(1, 2));
        System.out.println(d.divide(-2147483648, -1));
    }
}
