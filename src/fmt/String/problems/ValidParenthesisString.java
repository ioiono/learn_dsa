package fmt.String.problems;

/**
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 * Example 1:
 * Input: "()"
 * Output: True
 * Example 2:
 * Input: "(*)"
 * Output: True
 * Example 3:
 * Input: "(*))"
 * Output: True
 * Note:
 * The string size will be in the range [1, 100].
 */
// TODO
public class ValidParenthesisString {
//    public boolean checkValidString(String s) {
//        int[][] dp = new int[101][101];
//        int n = s.length();
//        dp[0][0] = 1;
//        for (int i = 1; i < n + 1; i++) {
//            char ch = s.charAt(i - 1);
//            if (ch == '(') {
//                dp[i] = dp[i - 1] << 1;
//            }
//        }
//    }
}
