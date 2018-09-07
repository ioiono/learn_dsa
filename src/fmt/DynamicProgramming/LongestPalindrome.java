package fmt.DynamicProgramming;

import java.util.HashSet;
import java.util.Set;

/**
 *
 Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

 This is case sensitive, for example "Aa" is not considered a palindrome here.

 Note:
 Assume the length of given string will not exceed 1,010.

 Example:

 Input:
 "abccccdd"

 Output:
 7

 Explanation:
 One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        boolean[] map = new boolean[128];
        int count = 0;
        for (char someChar : s.toCharArray()) {
            map[someChar] = !map[someChar];
            if (!map[someChar]) {
                count += 2;
            }
        }

        if (count < s.length()) {
            count++;
        }

        return count;
    }

    public int longestPalindrome2(String s) {
        Set<Character> set = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i))) {
                set.remove(s.charAt(i));
                cnt++;
            }
        }
        return set.isEmpty() ? 2 * cnt : 2 * cnt + 1;
    }


}
