package fmt.String.problems;

public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
//        else if (haystack.length() < needle.length()) {
//            return -1;
//        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementstrStr strstr = new ImplementstrStr();
        System.out.println(strstr.strStr("hello", ""));
    }
}
