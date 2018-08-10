package fmt.BinarySearch;

public class FindSmallestLetterGreaterThanTarget {
    // O(lgn)
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int lo = 0, hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (letters[mid] <= target) lo = mid + 1;
            else hi = mid;
        }
        return letters[lo % n];
    }

    public static void main(String[] args) {
        FindSmallestLetterGreaterThanTarget s = new FindSmallestLetterGreaterThanTarget();
        char[] a = new char[]{'c', 'f', 'j'};
        System.out.println(s.nextGreatestLetter(a, 'a'));
    }
}
