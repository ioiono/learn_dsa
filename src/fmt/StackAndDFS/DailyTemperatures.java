package fmt.StackAndDFS;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    // brute-force.. O(N^2)
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }

        return res;
    }

    private int[] dt(int[] t) {
        int[] res = new int[t.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < t.length; i++) {
            while (!stack.isEmpty() && t[i] > t[stack.peek()]) {
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }
        return res;

    }

    public static void main(String[] args) {
        int[] temps = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        DailyTemperatures dt = new DailyTemperatures();
        System.out.println(Arrays.toString(dt.dailyTemperatures(temps)));
        System.out.println(Arrays.toString(dt.dt(temps)));

    }
}
