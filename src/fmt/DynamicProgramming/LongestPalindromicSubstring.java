package fmt.DynamicProgramming;

public class LongestPalindromicSubstring {
    // time : O(n^2) space : O(n^2);
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        String res = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }

    private String res = "";

    // clean code
    // time : O(n^2) space : O(1)
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) return s;
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return res;
    }

    public void helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        String cur = s.substring(left + 1, right);
        if (cur.length() > res.length()) {
            res = cur;
        }
    }

    public String longestPalindrome3(String s) {
        if (s.length() < 2)
            return s;
        char[] ss = s.toCharArray();
        int len = 0;
        int a = 0;
        for (int i = 0; i < ss.length; i++) {
            int len1 = Len(ss, i, i);
            if (len1 > len) {
                len = len1;
                a = i - len1 / 2;
            }
            int len2 = Len(ss, i, i + 1);
            if (len2 > len) {
                len = len2;
                a = i - len2 / 2 + 1;
            }
        }
        // System.out.println(a+" "+len);
        return new String(ss, a, len);
    }

    private int Len(char[] ss, int l, int r) {
        while (l >= 0 && r < ss.length && ss[l] == ss[r]) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public static void main(String[] args) {
        String s = "babad";
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();

        System.out.println(lps.longestPalindrome(s));
        System.out.println(lps.longestPalindrome2(s));
        System.out.println(lps.longestPalindrome3(s));
    }
}
