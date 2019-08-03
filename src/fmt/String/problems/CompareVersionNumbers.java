package fmt.String.problems;

import java.util.Arrays;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] levels1 = version1.split("\\.");
        System.out.println("levels1 = " + Arrays.toString(levels1));
        String[] levels2 = version2.split("\\.");
        System.out.println("levels2 = " + Arrays.toString(levels2));
        int length = Math.max(levels1.length, levels2.length);
        for (int i = 0; i < length; i++) {
            Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String s1 = "1.1.1";
        String s2 = "1.1.2";
        System.out.println(new CompareVersionNumbers().compareVersion(s1, s2));

    }
}
