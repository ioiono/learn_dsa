package fmt.DynamicProgramming;

public class PainFence {
    // f(n) = (k-1)(f(n-1)+f(n-2))
    //Assuming there are 3 posts, if the first one and the second one has the same color,
    // then the third one has k-1 options. The first and second together has k options.
    //If the first and the second do not have same color, the total is k * (k-1),
    // then the third one has k options.
    // Therefore, f(3) = (k-1)*k + k*(k-1)*k = (k-1)(k+k*k)
    public int numWays(int n, int k) {
        int dp[] = {0, k, k * k, 0};

        if (n <= 2)
            return dp[n];

        for (int i = 2; i < n; i++) {
            dp[3] = (k - 1) * (dp[1] + dp[2]);
            dp[1] = dp[2];
            dp[2] = dp[3];
        }

        return dp[3];
    }

    int numWays2(int n, int k) {
        if (n == 0) return 0;
        int same = 0, diff = k;
        for (int i = 2; i <= n; ++i) {
            int t = diff;
            diff = (same + diff) * (k - 1);
            same = t;
        }
        return same + diff;
    }

    public static void main(String[] args) {
        PainFence pf = new PainFence();
        System.out.println(pf.numWays(3, 3));
        System.out.println(pf.numWays2(3, 3));
    }

}
