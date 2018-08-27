package fmt.DynamicProgramming;

public class PalindromicSubstrings {
    // space : O(n^2); DP
    public int countSubstrings2(String s) {
        if (s == null || s.length() == 0) return 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1]);
                if (dp[i][j]) res++;
            }
        }
        return res;
    }


    private int sum = 0;

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return sum;
    }


    public void helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            sum++;
            left--;
            right++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new PalindromicSubstrings().countSubstrings("aaa"));
    }
}
