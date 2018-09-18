package fmt.Math;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 * <p>
 * Example:
 * <p>
 * Input: 10 Output: 4 Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }

        return count;
    }

    public int countPrimes2(int n) {

        if (n <= 2) {
            return 0;
        }

        int c = 1;

        boolean isNotPrime[] = new boolean[n + 1];

        for (int i = 3; i * i <= n; i = i + 2) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= n; j = j + 2 * i) {
                    isNotPrime[j] = true;
                }
            }

        }

        for (int i = 3; i < n; i = i + 2) {
            if (!isNotPrime[i]) {
                c++;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        CountPrimes cp = new CountPrimes();
        System.out.println(cp.countPrimes(10));
    }
}
