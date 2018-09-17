package fmt.Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetPrimes {
    private static final int MAX = 10000;
    private static boolean[] primes = new boolean[MAX + 1];

    private static void getPrimes() {
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i <= GetPrimes.MAX; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= GetPrimes.MAX; j += i) {
                    primes[j] = false;
                }
            }
        }

    }

    public static void main(String[] args) {
        getPrimes();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i <= MAX; i++) {
            if (primes[i]) {
                res.add(i);
            }
        }
        System.out.println(res);
    }


}
