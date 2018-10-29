package fmt.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        dfs(S.toCharArray(), res, 0);
        return res;
    }

    private void dfs(char[] chars, List<String> res, int start) {

        Utils.indent(start);
        System.out.println("dfs(" + new String(chars) + ", " + res + ", " + start + ")");
        if (start == chars.length) {
            /****** DEBUG *******/
            System.out.println("Add => " + new String(chars));
            System.out.println("========================================================================================================");
            /****** DEBUG *******/

            res.add(new String(chars));
            return;
        }

        dfs(chars, res, start + 1);

        if (Character.isDigit(chars[start])) return;
        chars[start] ^= 32;
        dfs(chars, res, start + 1);
        //        chars[start] ^= 32;
    }

    public List<String> letterCasePermutation2(String S) {
        List<String> ans = new ArrayList<>(Arrays.asList(S));
        System.out.println(ans);
        for (int i = 0; i < S.length(); ++i) { // Traverse string S char by char.
            for (int j = 0, sz = ans.size(); S.charAt(i) > '9' && j < sz; ++j) { // S.charAt(i) > '9': letter, not digit.
                char[] ch = ans.get(j).toCharArray(); // transform to char[] the string @ j of ans.
                ch[i] ^= (1 << 5); // toggle case of charAt(i).
                ans.add(String.valueOf(ch)); // append to the end of ans.
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LetterCasePermutation lcp = new LetterCasePermutation();
        System.out.println(lcp.letterCasePermutation("ab"));
        //        System.out.println(lcp.letterCasePermutation(""));
        System.out.println(lcp.letterCasePermutation("a1b2"));
        System.out.println(lcp.letterCasePermutation2("a1b2"));
        //        System.out.println(lcp.letterCasePermutation("a1b2c3"));
    }


}
