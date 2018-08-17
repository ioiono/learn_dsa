package fmt.HashTable;

import fmt.BinarySearch.FirstBadVersion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * <p>
 * Examples:
 * <p>
 * s = "leetcode" return 0.
 * <p>
 * s = "loveleetcode", return 2. Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterinaString {

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (map.get(ch) == null) {
                map.put(ch, 1);
            } else if (map.get(ch) == 1) {
                map.put(ch, -1);
            } // repeat
        }

        for (char ch : s.toCharArray()) {
            if (map.get(ch) != null && map.get(ch) == 1) {
                return s.indexOf(ch);
            }
        }

        return -1;
    }

    public int firstUniqCharII(String s) {
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++)
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacterinaString f = new FirstUniqueCharacterinaString();
        System.out.println(f.firstUniqChar("leetcode"));
        System.out.println(f.firstUniqChar("loveleetcode"));
        System.out.println(f.firstUniqChar("aadadaad"));
    }
}
