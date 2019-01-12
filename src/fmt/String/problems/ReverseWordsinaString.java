package fmt.String.problems;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWordsinaString {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }


    public static void main(String[] args) {

    }
}
