package fmt.DynamicProgramming;

import java.util.HashMap;
import java.util.Stack;

public class LongestValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }

    // TLE O(N^3)
    public int longestValidParentheses(String s) {
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j += 2) {
                if (isValid(s.substring(i, j))) {
                    maxlen = Math.max(maxlen, j - i);
                }
            }
        }
        return maxlen;
    }

    public int longestValidParentheses2(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    /**
     * Complexity Analysis
     * <p>
     * Time complexity : O(n). nn is the length of the given string..
     * <p>
     * Space complexity : O(n). The size of stack can go up to nn.
     *
     * @param s
     *
     * @return
     */
    public int longestValidParentheses3(String s) {
        int maxlen = 0;
        Stack<Integer> stack = new Stack<>();

        // Initialize stack, push -1 first.
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            // when encounter '(' push the index onto stack
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // when encounter ')', pop the topmost element first
                // then subtract the index from the peek element (if the stack is not empty)
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    // keep the longest length of the valid substrings
                    maxlen = Math.max(maxlen, i - stack.peek());
                }
            }
        }

        return maxlen;
    }

    /**
     * Complexity Analysis
     * <p>
     * Time complexity : O(n). Two traversals of the string.
     * <p>
     * Space complexity : O(1). Only two extra variables left and right are needed.
     *
     * @param s
     *
     * @return
     */
    public int longestValidParentheses4(String s) {

        //second solution 11ms
        if (s.length() == 0) return 0;
        char[] temp = s.toCharArray();
        int max = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == '(')
                left++;
            else
                right++;
            if (right > left)
                left = right = 0;
            else if (right == left)
                max = Math.max(max, right * 2);
        }
        left = right = 0;
        for (int i = temp.length - 1; i >= 0; i--) {
            if (temp[i] == '(')
                left++;
            else
                right++;
            if (left > right)
                left = right = 0;
            else if (right == left)
                max = Math.max(max, left * 2);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestValidParentheses lvp = new LongestValidParentheses();
        System.out.println(lvp.longestValidParentheses3("))()()"));
        System.out.println(lvp.longestValidParentheses3("()()"));
        System.out.println(lvp.longestValidParentheses3(")()())"));
        System.out.println(lvp.longestValidParentheses3("()"));
        System.out.println(lvp.longestValidParentheses3("}{())()"));
    }
}
