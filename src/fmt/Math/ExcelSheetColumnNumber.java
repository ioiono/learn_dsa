package fmt.Math;

public class ExcelSheetColumnNumber {
    // Think of this problem as the same way you'd manually take a binary string and
    // calculate it's decimal representation.
    // Instead of being base 2 it is base 26.
    public int titleToNumber(String s) {
        int res = 0;
        int i = 0;
        while (i < s.length()) {
            res = res * 26 + (s.charAt(i) - 'A' + 1);
            i++;
        }
        return res;
    }

    public int titleToNumber2(String s) {
        int res = 0;
        for (char ch : s.toCharArray()) {
            res = res * 26 + (ch - 'A' + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("ZY"));
        System.out.println(new ExcelSheetColumnNumber().titleToNumber2("ZY"));
    }
}
