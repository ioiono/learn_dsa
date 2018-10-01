package fmt.Math;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * Example 1:
 *
 * Input: 1
 * Output: "A"
 * Example 2:
 *
 * Input: 28
 * Output: "AB"
 * Example 3:
 *
 * Input: 701
 * Output: "ZY"
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            n--;
            res.append((char) ('A' + n % 26));
            n /= 26;
        }
        res.reverse();
        return res.toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle esct = new ExcelSheetColumnTitle();
        System.out.println(esct.convertToTitle(1));
        System.out.println(esct.convertToTitle(701));
    }
}
