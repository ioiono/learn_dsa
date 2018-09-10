package fmt.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     * <p>
     * For example, given n = 3, a solution set is: [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
     *
     * @param n
     *
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left : generateParenthesis(c))
                    for (String right : generateParenthesis(n - 1 - c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }

    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        helper(res, "", n, n);
        return res;
    }

    public void helper(List<String> res, String s, int left, int right) {
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        if (left > 0) {
            helper(res, s + "(", left - 1, right);
        }
        if (right > 0) {
            helper(res, s + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        //        System.out.println(gp.generateParenthesis(3));
        System.out.println(gp.generateParenthesis2(3));
    }
}
