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

    public static void main(String[] args) {
        String str = "qwerty1";
        System.out.println(reverseString(str));
        System.out.println(reverseString1(str));
        System.out.println(reverseStringRec(str));
        System.out.println(str.substring(str.length() / 2));
    }
}
