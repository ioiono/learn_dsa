package fmt.String.problems;

// Greedy
public class StringWithoutAAAorBBB {
    // Let's maintain A, B: the number of 'a' and 'b''s left to write.
    //
    //If we have already written the most common letter twice, we'll write the other letter.
    // Otherwise, we'll write the most common letter.
    public String strWithout3a3b(int A, int B) {
        StringBuilder ans = new StringBuilder();

        while (A > 0 || B > 0) {
            int len = ans.length();
            boolean addA = false;
            if (len >= 2 && ans.charAt(len - 1) == ans.charAt(len - 2)) {
                if (ans.charAt(len - 1) == 'b')
                    addA = true;
            } else {
                if (A >= B)
                    addA = true;
            }

            if (addA) {
                A--;
                ans.append('a');
            } else {
                B--;
                ans.append('b');
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        StringWithoutAAAorBBB s = new StringWithoutAAAorBBB();

        System.out.println(s.strWithout3a3b(3, 1));
        System.out.println(s.strWithout3a3b(5, 2));
        System.out.println(s.strWithout3a3b(4, 1));
    }
}
