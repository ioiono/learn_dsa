package fmt.String.problems;


public class ReverseString {
    private static String reverseString(String str) {
        char[] chars = str.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;

            i++;
            j--;
        }
        return new String(chars);

    }

    private static String reverseString1(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    private static String reverseStringRec(String str) {
        int len = str.length();
        return len <= 1 ? str : (
                reverseString(str.substring(len / 2)) +
                        reverseString(str.substring(0, len / 2))
        );
    }
    private static void printReverse(char [] str) {
        helper(0, str);
        System.out.println();
    }

    private static void helper(int index, char [] str) {
        if (str == null || index >= str.length) {
            return;
        }
        helper(index + 1, str);
        System.out.print(str[index]);
    }
    public static void reverseString2(char[] s) {
        helper(0, s.length - 1, s);
    }

    private static void helper(int start, int end, char [] s) {
        if (start >= end) {
            return;
        }
        // swap between the first and the last elements.
        char tmp = s[start];
        s[start] = s[end];
        s[end] = tmp;

        helper(start + 1, end - 1, s);
    }
    public static void main(String[] args) {
        String str = "qwerty1";

        printReverse(str.toCharArray());

        System.out.println(reverseString(str));
        System.out.println(reverseString1(str));
        System.out.println(reverseStringRec(str));
        System.out.println(str.substring(str.length() / 2));
    }
}
