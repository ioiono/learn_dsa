package fmt.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        dfs(S.toCharArray(), res, 0);
        return res;
    }

    private void dfs(char[] chars, List<String> res, int start) {
        if (start == chars.length) {
            res.add(String.valueOf(chars));
            return;
        }
        dfs(chars, res, start + 1);

        if (Character.isDigit(chars[start])) return;
        chars[start] ^= 32;
        dfs(chars, res, start + 1);
        chars[start] ^= 32;
    }


    public static void main(String[] args) {
        LetterCasePermutation lcp = new LetterCasePermutation();
        System.out.println(lcp.letterCasePermutation("ab"));
        System.out.println(lcp.letterCasePermutation(""));
        System.out.println(lcp.letterCasePermutation("a1b2"));
        System.out.println(lcp.letterCasePermutation2("a1b2"));
    }


}
