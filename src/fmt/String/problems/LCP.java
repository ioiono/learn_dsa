package fmt.String.problems;

public class LCP {

    // https://soulmachine.gitbooks.io/algorithm-essentials/content/java/string/longest-common-prefix.html

    // 纵向扫描，从位置0开始，对每一个位置比较所有字符串，直到遇到一个不匹配
    // 时间复杂度O(n1+n2+...)
    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        for (int j = 0; j < strs[0].length(); ++j) { // 纵向扫描
            for (int i = 1; i < strs.length; ++i) {
                if (j == strs[i].length() ||
                        strs[i].charAt(j) != strs[0].charAt(j))
                    return strs[0].substring(0, j);
            }
        }
        return strs[0];
    }

    // 横向扫描，每个字符串与第0个字符串，从左到右比较，直到遇到一个不匹配，
    // O(n1+n2+...)
    private static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";

        int right_most = strs[0].length();
        for (int i = 1; i < strs.length; i++)
            for (int j = 0; j < right_most; j++)
                // 不会越界，请参考string::[]的文档
                if (j == strs[i].length() ||
                        strs[i].charAt(j) != strs[0].charAt(j))
                    right_most = j;

        return strs[0].substring(0, right_most);
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefix2(strs));

    }
}
