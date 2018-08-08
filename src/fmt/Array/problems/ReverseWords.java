package fmt.Array.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWords {
    private static String reverseWords(String s) {
        String[] parts = s.trim().split("\\s+");
        StringBuilder out = new StringBuilder();
        for (int i = parts.length - 1; i > 0; i--) {
            out.append(parts[i]).append(" ");
        }
        return out + parts[0];
    }

    private static String reverseWordsIII(String s) {
        return new ArrayList<>(Arrays.asList(s.split("\\s+"))).stream()
                .map(str -> new StringBuilder(str).reverse().toString())
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        System.out.println("[" + reverseWords(" a   c   d f    ") + "]");
        System.out.println("[" + reverseWordsIII("bca   apple   d f    ") + "]");
    }
}
