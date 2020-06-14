package fmt.Array.problems;

import java.util.Arrays;
import java.util.Stack;

public class FinalPricesWithASpecialDiscountInAShop {
    // O(N^2) Best->O(N)
    public int[] finalPrices(int[] prices) {
        if (prices.length == 0) {
            return new int[0];
        }
        int[] res = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int cur = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= cur) {
                    cur -= prices[j];
                    break;
                }
            }
            res[i] = cur;
        }
        return res;
    }
    // O(N)
    public int[] finalPrices2(int[] prices) {
        if (prices.length == 0) return new int[0];
        int[] res = prices.clone();
        // index of prices elements
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            int cur = prices[i];
            while (!s.isEmpty() && cur <= prices[s.peek()]) {
                res[s.peek()] -= cur;
                s.pop();
            }
            s.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = {8, 4, 6, 2, 3};
        System.out.println(Arrays.toString(new FinalPricesWithASpecialDiscountInAShop().finalPrices(ints)));
        System.out.println(Arrays.toString(new FinalPricesWithASpecialDiscountInAShop().finalPrices2(ints)));
    }
}
