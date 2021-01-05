package fmt.Array.problems;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] num) {
        if(num == null || num.length == 0)
            return "";

        // Convert int array to String array, so we can sort later on
        String[] arr = new String[num.length];
        for(int i = 0; i < num.length; i++)
            arr[i] = String.valueOf(num[i]);

        // Comparator to decide which string should come first in concatenation
        Comparator<String> comp = (str1, str2) -> {
            String s1 = str1 + str2;
            String s2 = str2 + str1;
            return s2.compareTo(s1); // reverse order here, so we can do append() later
        };

        Arrays.sort(arr, comp);
        // An extreme edge case by lc, say you have only a bunch of 0 in your int array
        if(arr[0].charAt(0) == '0')
            return "0";

        StringBuilder sb = new StringBuilder();
        for(String s: arr)
            sb.append(s);

        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(new LargestNumber().largestNumber(new int[]{1,3,4,10,0,12,82}));
    }
}
