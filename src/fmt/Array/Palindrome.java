package fmt.Array;

public class Palindrome {
    public boolean isPalindromeIter(int[] array) {
        int length = array.length;
        for (int index = 0; index < array.length; index++) {
            // get the element from the start
            int start = array[index];
            // get corresponding element from end
            int end = array[--length];
            // check if elements till the middle have been compared
            if (length < index) {
                return true;
            }
            // if start element is not the same as end element, the array is not
            // palindrome
            if (start != end) {
                return false;
            }
        }
        // if the control reaches here, means all the elements were same
        return true;
    }


    public boolean isPalindrome(int[] array, int startIndex, int endIndex) {
        // if array is empty or has 1 element, it is palindrome
        if (array.length == 0 || array.length == 1)
            return true;
        // check if start index is greater than end index, which means
        // whole array has been checked
        if (startIndex >= endIndex)
            return true;
        // check if element from left is not equal to element from last,
        // then array is not palindrome
        if (array[startIndex] != array[endIndex])
            return false;
        // check for palindrome with start index incremented and end index
        // decreased by 1
        return isPalindrome(array, startIndex + 1, endIndex - 1);
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 3, 2, 1};
        int[] ints2 = new int[]{1, 2, 3, 3, 2, 1, 0};
        Palindrome p = new Palindrome();
        System.out.println(p.isPalindrome(ints, 0, ints.length - 1));
        System.out.println(p.isPalindromeIter(ints));
        System.out.println(p.isPalindrome(ints2, 0, ints2.length - 1));
        System.out.println(p.isPalindromeIter(ints2));
    }
}
