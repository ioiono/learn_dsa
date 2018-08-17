package fmt.HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No
 * two characters may map to the same character but a character may map to itself.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "egg", t = "add" Output: true Example 2:
 * <p>
 * Input: s = "foo", t = "bar" Output: false Example 3:
 * <p>
 * Input: s = "paper", t = "title" Output: true Note: You may assume both s and t have the same length.
 */
public class IsomorphicStrings {
    // time : O(n) space : O(n)
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) return true;
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map.containsKey(a)) {
                if (map.get(a).equals(b)) continue;
                else return false;
            } else {
                if (!map.containsValue(b)) {
                    map.put(a, b);
                } else return false;
            }
        }
        return true;
    }


    // time : O(n) space : O(1)
    public boolean isIsomorphic2(String s, String t) {
        int[] sChars = new int[256];
        int[] tChars = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (sChars[s.charAt(i)] != tChars[t.charAt(i)]) {
                return false;
            } else {
                sChars[s.charAt(i)] = t.charAt(i);
                tChars[t.charAt(i)] = t.charAt(i);
            }
        }
        return true;
    }

    public boolean isIsomorphic22(String s, String t) {
        int[] sChars = new int[256];
        int[] tChars = new int[256];
        int label = 1;
        for (int i = 0; i < s.length(); i++) {
            if (sChars[s.charAt(i)] != tChars[t.charAt(i)]) {
                return false;
            } else {
                sChars[s.charAt(i)] = label;
                tChars[t.charAt(i)] = label;
                label++;
            }
        }
        return true;
    }

    public boolean isIsomorphic3(String s, String t) {
        Map m = new HashMap();
        for (Integer i = 0; i < s.length(); ++i)
            if (m.put(s.charAt(i), i) != m.put(t.charAt(i) + "", i))
                return false;
        return true;
    }

    // clean code
    public boolean isIsomorphic4(String s, String t) {
        if (s.length() != t.length()) return false;

        final Map<Character, Character> map1 = new HashMap<>();
        final Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            final char c1 = s.charAt(i);
            final char c2 = t.charAt(i);

            if (map1.containsKey(c1)) {
                if (map1.get(c1) != c2) return false;
            } else {
                map1.put(c1, c2);
            }

            if (map2.containsKey(c2)) {
                if (map2.get(c2) != c1) return false;
            } else {
                map2.put(c2, c1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings is = new IsomorphicStrings();

        String s = "title", t = "paper";
        System.out.println(is.isIsomorphic(s, t));
        System.out.println(is.isIsomorphic2(s, t));
        System.out.println(is.isIsomorphic3(s, t));
        System.out.println(is.isIsomorphic4(s, t));

    }


}
