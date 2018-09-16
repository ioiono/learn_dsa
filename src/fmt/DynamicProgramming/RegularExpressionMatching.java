package fmt.DynamicProgramming;

public class RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] pat = p.toCharArray();

        boolean[][] t = new boolean[str.length + 1][pat.length + 1];
        t[0][0] = true;

        //deal with pattern *a*b
        for (int i = 1; i < t[0].length; i++) {
            if (pat[i - 1] == '*') {
                t[0][i] = t[0][i - 2];
            }
        }

        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j < t[0].length; j++) {
                if (pat[j - 1] == '.' || str[i - 1] == pat[j - 1]) {
                    t[i][j] = t[i - 1][j - 1];
                } else if (pat[j - 1] == '*') {
                    t[i][j] = t[i][j - 2];
                    if (pat[j - 2] == '.' || pat[j - 2] == str[i - 1]) {
                        t[i][j] = t[i][j] | t[i - 1][j];
                    }
                } else {
                    t[i][j] = false;
                }
            }
        }

        return t[str.length][pat.length];

    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a*"));
    }
}