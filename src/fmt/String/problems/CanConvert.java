package fmt.String.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CanConvert {
    /**
     * @param s: string S
     * @param t: string T
     * @return: whether S can convert to T
     */
    public boolean canConvert(String s, String t) {
        if (s == null) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        } else if (s.length() <= t.length()) {
            return false;
        }
        for (int i = 0; i <= s.length() - t.length(); i++) {
            if (s.charAt(i) == t.charAt(0)) {
                if (s.substring(i, i + t.length()).equals(t)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanConvert cc = new CanConvert();

        System.out.println(cc.canConvert("apple","le"));
    }
}
