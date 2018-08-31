package fmt.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(i, j, 0, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(int i, int j, int distance, char[][] board, String word) {
        if (distance == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (word.charAt(distance) != board[i][j]) return false;
        board[i][j] ^= 117;
        boolean exist = search(i - 1, j, distance + 1, board, word) ||
                search(i, j - 1, distance + 1, board, word) ||
                search(i + 1, j, distance + 1, board, word) ||
                search(i, j + 1, distance + 1, board, word);
        board[i][j] ^= 117;
        return exist;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (!res.contains(word) && this.exist(board, word)) {
                res.add(word);
            }
        }
        return res;
    }

    //
    //
    //
    //    class TrieNode {
    //        String word;
    //        TrieNode[] children = new TrieNode[26];
    //    }
    //
    //    public List<String> findWordsTrie(char[][] board, String[] words) {
    //        List<String> res = new ArrayList<>();
    //        TrieNode root = new TrieNode();
    //        buildTrie(words, root);
    //        for (int i = 0; i < board.length; i++) {
    //            for (int j = 0; j < board[0].length; j++) {
    //                dfs(board, i, j, root, res);
    //            }
    //        }
    //        return res;
    //    }
    //
    //    public void dfs(char[][] board, int i, int j, TrieNode root, List<String> res) {
    //        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
    //        char c = board[i][j];
    //        if (board[i][j] == '#' || root.children[c - 'a'] == null) return;
    //        root = root.children[c - 'a'];
    //        if (root.word != null) {
    //            res.add(root.word);
    //            root.word = null;// 去重
    //        }
    //        board[i][j] = '#';
    //        dfs(board, i + 1, j, root, res);
    //        dfs(board, i, j + 1, root, res);
    //        dfs(board, i - 1, j, root, res);
    //        dfs(board, i, j - 1, root, res);
    //        board[i][j] = c;
    //    }
    //
    //    public void buildTrie(String[] words, TrieNode root) {
    //        for (String word : words) {
    //            TrieNode p = root;
    //            char[] array = word.toCharArray();
    //            for (char c : array) {
    //                if (p.children[c - 'a'] == null) {
    //                    p.children[c - 'a'] = new TrieNode();
    //                }
    //                p = p.children[c - 'a'];
    //            }
    //            p.word = word;
    //        }
    //    }
    public List<String> findWordsTrie(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j, p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        char[][] board = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        WordSearchII w = new WordSearchII();
        System.out.println(w.findWords(board, words));
        System.out.println(w.findWordsTrie(board, words));
    }
}
