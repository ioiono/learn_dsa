package fmt.DynamicProgramming;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int f = 0; // first
        int g = 1; // second
        while (n-- > 0) {
            g = f + g; // third
            f = g - f; // second
        }
        return g;
    }

    // TLE xd O(2^n)
    public int climbStairsRec(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else if (n == 2) return 2;
        else return climbStairsRec(n - 1) + climbStairsRec(n - 2);
    }

    public int climbStairsMoi(int n) {
        int mem[] = new int[n + 1];
        return climb(n, mem);
    }

    private int climb(int n, int[] mem) {
        if (n <= 1)      return 1;
        if (mem[n] != 0) return mem[n];
        else             return mem[n] = climb(n - 1, mem) + climb(n - 2, mem);
    }

    /**
     * Time complexity : O(n). Single loop upto n.
     * <p>
     * Space complexity : O(n). dp array of size n is used.
     *
     * @param n
     *
     * @return
     */
    public int climbStairsII(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairsIII(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) (fibn / sqrt5);
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(44));
        System.out.println(cs.climbStairsMoi(44));
    }
}
