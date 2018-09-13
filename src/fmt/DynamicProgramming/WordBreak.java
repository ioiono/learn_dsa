package fmt.DynamicProgramming;

import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] f = new boolean[s.length() + 1];

        f[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String str : wordDict) {
                if (str.length() <= i && f[i - str.length()]) {
                    if (s.substring(i - str.length(), i).equals(str)) {
                        f[i] = true;
                        break;
                    }
                }
            }
        }

        return f[s.length()];

    }

    public boolean wordBreak2(String s, List<String> wordDict) {

        boolean[] f = new boolean[s.length() + 1];

        f[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];

    }

    public boolean wordBreak3(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<String>(wordDict);
        Map<String, Boolean> mem = new HashMap<String, Boolean>();
        return wordBreak(s, mem, dict);
    }

    private boolean wordBreak(String s,
                              Map<String, Boolean> mem,
                              Set<String> dict) {
        if (mem.containsKey(s)) return mem.get(s);
        if (dict.contains(s)) {
            mem.put(s, true);
            return true;
        }

        for (int i = 1; i < s.length(); ++i) {
            if (dict.contains(s.substring(i)) && wordBreak(s.substring(0, i), mem, dict)) {
                mem.put(s, true);
                return true;
            }
        }

        mem.put(s, false);
        return false;
    }

    public static void main(String[] args) {

    }
}
