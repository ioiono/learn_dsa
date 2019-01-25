package fmt.QueueAndBFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordLadder {
    private int diff(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                res++;
            }
        }
        return res;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        for (int i = 0; i < wordList.size(); i++) {
            String cur = wordList.get(i);
            if (cur.equals(endWord)) {
                if (diff(beginWord, endWord) <= 1) {
                    return i;
                }
            }
            if (diff(cur, beginWord) == 1) {
                System.out.println(cur+beginWord);
                beginWord = cur;
            } else {
                return 0;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder w = new WordLadder();
        System.out.println(
                w.ladderLength("hit", "cog,", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot",
                        "log", "cog"))));
    }
}
