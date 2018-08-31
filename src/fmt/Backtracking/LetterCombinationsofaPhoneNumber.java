package fmt.Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinationsDFS(String digits) {
        String[] d = new String[]{
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
        char[] cur = new char[digits.length()];
        List<String> ans = new ArrayList<>();
        dfs(digits, d, 0, cur, ans);
        return ans;
    }

    private void dfs(String digits, String[] d,
                     int l, char[] cur, List<String> ans) {
        if (l == digits.length()) {
            if (l > 0) ans.add(new String(cur));
            return;
        }

        for (char ch : d[digits.charAt(l) - '0'].toCharArray()) {
            cur[l] = ch;
            dfs(digits, d, l + 1, cur, ans);
        }
    }


    private String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        helper(res, digits, "", 0);
        return res;
    }

    public void helper(List<String> res, String digits, String s, int index) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        String letters = mapping[s.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            helper(res, digits, s + letters.charAt(i), index + 1);
        }
    }

    public List<String> letterCombinations2(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            while (res.peek().length() == i) {
                String t = res.remove();
                for (char s : mapping[digits.charAt(i) - '0'].toCharArray()) {
                    res.add(t + s);
                }
            }
        }
        return res;
    }

    public List<String> letterCombinations3(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.isEmpty()) return ans;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        while (ans.peek().length() != digits.length()) {
            String remove = ans.remove();
            String map = mapping[digits.charAt(remove.length()) - '0'];
            for (char c : map.toCharArray()) {
                ans.addLast(remove + c);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber l = new LetterCombinationsofaPhoneNumber();
        System.out.println(l.letterCombinations2("235"));
        System.out.println(l.letterCombinationsDFS("235"));
    }

}
