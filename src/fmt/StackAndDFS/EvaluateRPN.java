package fmt.StackAndDFS;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class EvaluateRPN {
    public int evalRPN(String[] tokens) {
        int a, b;
        Stack<Integer> S = new Stack<Integer>();
        for (String s : tokens) {
            switch (s) {
                case "+":
                    S.push(S.pop() + S.pop());
                    break;
                case "/":
                    b = S.pop();
                    a = S.pop();
                    S.push(a / b);
                    break;
                case "*":
                    S.push(S.pop() * S.pop());
                    break;
                case "-":
                    b = S.pop();
                    a = S.pop();
                    S.push(a - b);
                    break;
                default:
                    S.push(Integer.parseInt(s));
                    break;
            }
        }
        return S.pop();
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"2", "1", "/", "3", "*"};
        System.out.println(new EvaluateRPN().evalRPN(tokens));
    }
}
