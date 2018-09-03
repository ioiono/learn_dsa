package fmt.DynamicProgramming;

public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            // now prices[i] > prices[i+1]
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }
    // WTF...
    public int maxProfitWTF(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                max += prices[i] - prices[i - 1];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        BestTimetoBuyandSellStockII b = new BestTimetoBuyandSellStockII();
        System.out.println(b.maxProfit(prices));
        System.out.println(b.maxProfitWTF(prices));
    }
}
