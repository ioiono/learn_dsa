package fmt.String.problems;

/**
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this
 * string is valid. We define the validity of a string by these rules:
 * <p>
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'. Any right parenthesis ')' must have a
 * corresponding left parenthesis '('. Left parenthesis '(' must go before the corresponding right parenthesis ')'. '*'
 * could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string. An empty
 * string is also valid. Example 1: Input: "()" Output: True Example 2: Input: "(*)" Output: True Example 3: Input:
 * "(*))" Output: True Note: The string size will be in the range [1, 100].
 */
// TODO
public class ValidParenthesisString {
    // 2ms
    public boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for (char c : s.toCharArray()) {
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if (hi < 0) break;
            lo = Math.max(lo, 0);
        }
        return lo == 0;
    }

    // ~200ms
    public boolean checkValidString2(String s) {
        return check(s, 0, 0);
    }

    private boolean check(String s, int start, int count) {
        if (count < 0) return false;

        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                if (count <= 0) return false;
                count--;
            } else if (c == '*') {
                return check(s, i + 1, count + 1) || check(s, i + 1, count - 1) || check(s, i + 1, count);
            }
        }

        return count == 0;
    }

    public static void main(String[] args) {
        ValidParenthesisString vps = new ValidParenthesisString();

        System.out.println(vps.checkValidString(")("));
        System.out.println(vps.checkValidString("()*)"));
        System.out.println(vps.checkValidString("(*"));
        System.out.println(vps.checkValidString("*)"));
    }
}
