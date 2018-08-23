package fmt.Trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    char val;
    boolean isWord;

    TrieNode(char val, boolean isWord) {
        this.val = val;
        this.children = new HashMap<>();
        this.isWord = isWord;
    }
}

class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode('-', false);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = this.root;
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if (!cur.children.containsKey(ch)) {
                if (i == charArray.length - 1)
                    cur.children.put(ch, new TrieNode(ch, true));
                else
                    cur.children.put(ch, new TrieNode(ch, false));
            } else { // update value only
                if (i == charArray.length - 1) {
                    cur.children.get(ch).isWord = true;
                } else {
                    // do nothing
                }
            }
            cur = cur.children.get(ch);
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = this.root;
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if (!cur.children.containsKey(ch)) {
                return false;
            } else {
                if (i == charArray.length - 1) {
                    return cur.children.get(ch).isWord;
                }
                cur = cur.children.get(ch);
            }
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = this.root;
        char[] charArray = prefix.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if (!cur.children.containsKey(ch)) {
                return false;
            } else {
                if (i == charArray.length - 1) {
                    return true;
                }
                cur = cur.children.get(ch);
            }
        }
        return false;
    }

}

/**
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple"); trie.search("apple");   // returns true trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true trie.insert("app"); trie.search("app");     // returns true
 */
public class ImplementTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));


    }

}
