package fmt.DynamicProgramming;

public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int len = days[days.length - 1];
        boolean[] travelDays = new boolean[len + 1];
        int[] dp = new int[len + 1];
        for (int day : days) {
            travelDays[day] = true;
        }
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            if (!travelDays[i]) {
                dp[i] = dp[i - 1];
                continue;
            }
            dp[i] = dp[i - 1] + costs[0];
            dp[i] = Math.min(dp[i], dp[Math.max(0, i - 7)] + costs[1]);
            dp[i] = Math.min(dp[i], dp[Math.max(0, i - 30)] + costs[2]);

        }

        return dp[dp.length - 1];
    }
}
