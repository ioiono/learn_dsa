package fmt.DynamicProgramming;

import java.util.Arrays;
import java.util.Collections;

/**
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the
 * fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [1, 2, 5], amount = 11 Output: 3 Explanation: 11 = 5 + 5 + 1 Example 2:
 * <p>
 * Input: coins = [2], amount = 3 Output: -1
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {
    public int coinChangeTLE(int[] coins, int amount) {
        return coinChange(0, coins, amount);
    }

    private int coinChange(int idxCoin, int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (idxCoin < coins.length && amount > 0) {
            int maxVal = amount / coins[idxCoin];
            int minCost = Integer.MAX_VALUE;
            for (int x = 0; x <= maxVal; x++) {
                if (amount >= x * coins[idxCoin]) {
                    int res = coinChange(idxCoin + 1, coins, amount - x * coins[idxCoin]);
                    if (res != -1)
                        minCost = Math.min(minCost, res + x);
                }
            }
            return (minCost == Integer.MAX_VALUE) ? -1 : minCost;
        }
        return -1;
    }    // Time Limit Exceeded 2^N


    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0; // PS
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // ~14ms
    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) dp[i] = amount + 1;
        for (int coin : coins)
            for (int i = coin; i <= amount; i++)
                dp[i] = Math.min(dp[i], dp[i - coin] + 1); // use current or not

        System.out.println(Arrays.toString(dp));
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // DFS+GREEDY+PRUNING
    // use largest and as many as coins first ro reduce the search space
    private int res = Integer.MAX_VALUE;

    public int coinChangeDFS(int[] coins, int amount) {
        Arrays.sort(coins);
        reverse(coins);
        coinChangeDFS(coins, 0, amount, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void coinChangeDFS(int[] coins, int index, int amount, int count) {
        int coin = coins[index];
        if (index == coins.length - 1) {
            if (amount % coin == 0) {
                res = Math.min(res, count + (amount / coin));
            }
        } else {
            for (int k = amount / coin; k >= 0 && count + k < res; k--) {
                // use max as many as it can use
                coinChangeDFS(coins, index + 1, amount - k * coin, count + k);
            }
        }
    }

    private void reverse(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int t = nums[hi];
            nums[hi] = nums[lo];
            nums[lo] = t;
            lo++;
            hi--;
        }
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5, 10};
        int[] coins2 = new int[]{1, 3, 5, 7};
        int[] coins3 = new int[]{1, Integer.MAX_VALUE - 1};
        System.out.println(new CoinChange().coinChangeDFS(coins3, 13));

        System.out.println(new CoinChange().coinChange2(coins, 11));
        System.out.println(new CoinChange().coinChange2(coins, 13));
        System.out.println(new CoinChange().coinChangeDFS(coins, 11));
        System.out.println(new CoinChange().coinChangeDFS(coins, 13));
        System.out.println(new CoinChange().coinChange2(coins2, 8));
        System.out.println(new CoinChange().coinChange2(coins2, 16));
    }
}
