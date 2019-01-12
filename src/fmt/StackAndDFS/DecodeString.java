package fmt.StackAndDFS;

public class DecodeString {
    private int begin = 0;
    public String decodeString(String s) {
        return decodeArray(s.toCharArray());
    }

    private String decodeArray(char[] s) {
        StringBuilder sb = new StringBuilder();
        while (begin < s.length && s[begin] != ']') {
            if (!Character.isDigit(s[begin])) {
                sb.append(s[begin++]);
            } else {
                int n = 0;
                while (Character.isDigit(s[begin]))
                    n = n * 10 + (s[begin++] - '0');

                begin++;
                String sub = decodeArray(s);
                begin++;
                while (n-- > 0)
                    sb.append(sub);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DecodeString ds = new DecodeString();

        System.out.println(ds.decodeString("1[v]3[a]2[bc]"));
    }
}
