package fmt.String.problems;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        char[] chary = s.toCharArray();
        int i = 0, len = chary.length - 1;
        while (i <= len) {
            if (chary[i++] != chary[len--]) {
                return verify(chary, i, len + 1) || verify(chary, i - 1, len);
            }
        }

        return true;
    }

    public boolean verify(char[] chary, int i, int j) {
        while (i <= j) if (chary[i++] != chary[j--]) return false;
        return true;
    }
}
