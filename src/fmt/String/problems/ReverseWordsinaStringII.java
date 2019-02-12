package fmt.String.problems;

public class ReverseWordsinaStringII {

    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);  // reverse the whole string first
        int index = 0;
        while (index < s.length) {
            int l = index;
            while (index < s.length && s[index] != ' ') index++;
            reverse(s, l, index - 1);  // reverse words one by one
            index++;
        }
    }

    public void reverse(char[] s, int l, int r) {
        while (l < r) {
            char tmp = s[l];
            s[l++] = s[r];
            s[r--] = tmp;
        }
    }

}
