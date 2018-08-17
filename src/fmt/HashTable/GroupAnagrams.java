package fmt.HashTable;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 * <p>
 * Example:
 * <p>
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"], Output: [ ["ate","eat","tea"], ["nat","tan"], ["bat"] ] Note:
 * <p>
 * All inputs will be in lowercase. The order of your output does not matter.
 */
public class GroupAnagrams {


    /**
     * Time Complexity: O(NKlogK), where NN is the length of strs, and KK is the maximum length of a string in strs. The
     * outer loop has complexity O(N)O(N) as we iterate through each string. Then, we sort each string in O(K \log
     * K)O(KlogK) time.
     * <p>
     * Space Complexity: O(NK), the total information content stored in ans.
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    /**
     * Time Complexity: O(NK), where NN is the length of strs, and KK is the maximum length of a string in strs.
     * Counting each string is linear in the size of the string, and we count every string.
     * <p>
     * Space Complexity: O(NK), the total information content stored in ans.
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    // 计算字母ascii和是错的。。 有可能字母不一样和一样不是。。。反函数也要是函数
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs2 = new String[]{"", ""};
        GroupAnagrams ga = new GroupAnagrams();
        System.out.println(ga.groupAnagrams(strs));
        System.out.println(ga.groupAnagrams2(strs));
        System.out.println(ga.groupAnagrams(strs2));
        System.out.println(ga.groupAnagrams2(strs2));
    }
}
