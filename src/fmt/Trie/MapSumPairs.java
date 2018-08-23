package fmt.Trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Complexity Analysis
 * <p>
 * Time Complexity: Every insert operation is O(1)O(1). Every sum operation is O(N * P)O(N∗P) where NN is the number of
 * items in the map, and PP is the length of the input prefix.
 * <p>
 * Space Complexity: The space used by map is linear in the size of all input key and val values combined.
 */
class MapSum {
    HashMap<String, Integer> map;

    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int ans = 0;
        for (String key : map.keySet()) {
            if (key.startsWith(prefix)) {
                ans += map.get(key);
            }
        }
        return ans;
    }
}

/**
 * Complexity Analysis
 * <p>
 * Time Complexity: Every insert operation is O(K^2), where K is the length of the key, as K strings are made of an
 * average length of K. Every sum operation is O(1).
 * <p>
 * Space Complexity: The space used by map and score is linear in the size of all input key and val values combined.
 */
class MapSumI {
    Map<String, Integer> map;
    Map<String, Integer> score;

    public MapSumI() {
        map = new HashMap<>();
        score = new HashMap<>();
    }

    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        String prefix = "";
        for (char c : key.toCharArray()) {
            prefix += c;
            score.put(prefix, score.getOrDefault(prefix, 0) + delta);
        }
    }

    public int sum(String prefix) {
        return score.getOrDefault(prefix, 0);
    }
}

/**
 * Complexity Analysis
 *
 * Time Complexity: Every insert operation is O(K), where KK is the length of the key. Every sum operation is O(K).
 *
 * Space Complexity: The space used is linear in the size of the total input.
 */
class MapSumII {
    HashMap<String, Integer> map;
    TrieNodeI root;

    public MapSumII() {
        map = new HashMap();
        root = new TrieNodeI();
    }

    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNodeI cur = root;
        cur.score += delta;
        for (char c : key.toCharArray()) {
            cur.children.putIfAbsent(c, new TrieNodeI());
            cur = cur.children.get(c);
            cur.score += delta;
        }
    }

    public int sum(String prefix) {
        TrieNodeI cur = root;
        for (char c : prefix.toCharArray()) {
            cur = cur.children.get(c);
            if (cur == null) return 0;
        }
        return cur.score;
    }
}

class TrieNodeI {
    Map<Character, TrieNodeI> children = new HashMap<>();
    int score;
}

public class MapSumPairs {
    public static void main(String[] args) {

    }
}
