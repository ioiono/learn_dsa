package fmt.StackAndDFS;

import java.util.Stack;

public class ValidParentheses {
    boolean isLeftPare(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    boolean isRightPare(char ch) {
        return ch == ')' || ch == ']' || ch == '}';
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : chars) {
            if (isRightPare(ch) && stack.isEmpty()) return false;
            if (isLeftPare(ch)) {
                stack.push(ch);
            } else if (ch == ']') {
                if (stack.peek() == '[') {
                    stack.pop();
                } else return false;
            } else if (ch == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                } else return false;
            } else if (ch == '}') {
                if (stack.peek() == '{') {
                    stack.pop();
                } else return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid(")"));
        System.out.println(new ValidParentheses().isValid("("));
        System.out.println(new ValidParentheses().isValid("()"));
        System.out.println(new ValidParentheses().isValid("([)]"));
        System.out.println(new ValidParentheses().isValid("[()]"));
        System.out.println(new ValidParentheses().isValid2("[()]"));
    }
}

