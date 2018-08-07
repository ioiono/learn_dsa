package fmt.queueAndBFS;

import java.util.*;

public class PerfectSquares {

    private int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        int steps = 0;
        queue.offer(n);
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //noinspection ConstantConditions
                int cur = queue.poll();
                if (!set.add(cur)) continue;
                for (int j = 1; j <= Math.sqrt(cur); j++) {
                    int next = cur - j * j;
                    if (next == 0) {
                        return steps;
                    }
                    queue.offer(next);
                }
            }
        }
        return 0;
    }

    // TLE
    private int numSquares2(int n) {
        int[] res = new int[n + 1];
        Arrays.fill(res, -1);

        res[0] = 0;
        Queue<Integer> que = new LinkedList<>();
        que.offer(0);

        for (; !que.isEmpty(); que.poll()) {
            int m = que.peek();
            for (int i = 1; i * i + m <= n; i++) {
                if (res[i * i + m] == -1) {
                    res[i * i + m] = res[m] + 1;
                    que.offer(i * i + m);
                }
            }
        }

        return res[n];
    }

    private int numSquaresDP(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int root = 1; root * root <= i; root++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - root * root]);
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        PerfectSquares ps = new PerfectSquares();
        System.out.println(ps.numSquares(12));
        System.out.println(ps.numSquares2(12));
        System.out.println(ps.numSquaresDP(12));

        System.out.println(ps.numSquares(13));
        System.out.println(ps.numSquares2(13));
        System.out.println(ps.numSquaresDP(13));
    }
}
