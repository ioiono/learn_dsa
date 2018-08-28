package fmt.String.problems;

public class CountandSay {
    /**
     * The count-and-say sequence is the sequence of integers with the first five terms as following:
     * <p>
     * 1.     1 2.     11 3.     21 4.     1211 5.     111221 1 is read off as "one 1" or 11. 11 is read off as "two 1s"
     * or 21. 21 is read off as "one 2, then one 1" or 1211. Given an integer n, generate the nth term of the
     * count-and-say sequence.
     * <p>
     * Note: Each term of the sequence of integers will be represented as a string.
     * <p>
     * Example 1:
     * <p>
     * Input: 1 Output: "1" Example 2:
     * <p>
     * Input: 4 Output: "1211"
     *
     * @param n: the nth
     *
     * @return: the nth sequence
     */
    public String countAndSay(int n) {
        String str = "1";
        if (n == 1) return str;
        while (n-- > 1) {
            str = gen(str);
        }
        return str;
    }

    private String gen(String str) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < str.length(); ) {
            int cnt = 0;
            char cur = str.charAt(i);
            while (i < str.length() && cur == str.charAt(i)) {
                i++;
                cnt++;
            }
            s.append(cnt).append(cur);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        CountandSay cs = new CountandSay();
        System.out.println(cs.countAndSay(4));
        System.out.println(cs.countAndSay(5));
        System.out.println(cs.countAndSay(6));
        System.out.println(cs.countAndSay(7));
    }
}
