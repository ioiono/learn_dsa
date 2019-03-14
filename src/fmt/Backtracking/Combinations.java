package fmt.Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combineTLE(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        backtrack(n, k, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int n, int k, List<List<Integer>> res, List<Integer> list) {
        if (list.size() == k) {
            List<Integer> tmp = new ArrayList<>(list);
            Collections.sort(tmp);
            if (res.contains(tmp)) return;
            else res.add(tmp);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (list.contains(i)) continue;
            list.add(i);
            backtrack(n, k, res, list);
            list.remove(list.size() - 1);
        }
    }


    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<>();
        combine(combs, new ArrayList<>(), 1, n, k);
        return combs;
    }

    private void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if (k == comb.size()) {
            combs.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i <= n; i++) {
            comb.add(i);
            combine(combs, comb, i + 1, n, k);
            comb.remove(comb.size() - 1);
        }
    }

    // Optimization...
    public List<List<Integer>> combineII(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        recurHelper(result, new ArrayList<>(), 1, n, k);

        return result;
    }

    private void recurHelper(List<List<Integer>> result, List<Integer> element, int start, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(element));
            return;
        }
        // PS N - K + 1 HUGE OPTIMIZATION HERE...
        for (int i = start; i <= n - k + 1; i++) {
            element.add(i);
            recurHelper(result, element, i + 1, n, k - 1);
            element.remove(element.size() - 1);
        }
    }


    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        // C(k, n)
        System.out.println(new Combinations().combine(n, k));
        System.out.println(new Combinations().combineII(n, k));
    }

}
