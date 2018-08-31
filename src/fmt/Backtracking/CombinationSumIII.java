package fmt.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    private final int NUMBER = 9;

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        recurHelper(res, new ArrayList<>(), 1, n, k);

        return res;
    }

    private void recurHelper(List<List<Integer>> result, List<Integer> element, int start, int n, int k) {
        if (k == 0) {
            if (n == 0) result.add(new ArrayList<>(element));
            return;
        }
        // PS N - K + 1 HUGE OPTIMIZATION HERE...
        // end search when its not possible to have any combination
        for (int i = start; i <= this.NUMBER - k + 1; i++) {
            element.add(i);
            recurHelper(result, element, i + 1, n - i, k - 1);
            element.remove(element.size() - 1);
        }
    }

    public static void main(String[] args) {
        int k = 3, n = 18;
        CombinationSumIII cs = new CombinationSumIII();
        System.out.println(cs.combinationSum3(k, n));
    }
}
