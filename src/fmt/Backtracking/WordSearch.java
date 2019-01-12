package fmt.Backtracking;

public class WordSearch {
    //    public boolean exist(char[][] board, String word) {
    //        for (int i = 0; i < board.length; i++) {
    //            for (int j = 0; j < board[0].length; j++) {
    //                if (search(i, j, 0, board, word)) {
    //                    return true;
    //                }
    //            }
    //        }
    //        return false;
    //    }
    //
    //    private boolean search(int i, int j, int distance, char[][] board, String word) {
    //        if (distance == word.length()) return true;
    //        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
    //        if (word.charAt(distance) != board[i][j]) return false;
    //        board[i][j] ^= 117;
    //        boolean exist = search(i - 1, j, distance + 1, board, word) ||
    //                search(i, j - 1, distance + 1, board, word) ||
    //                search(i + 1, j, distance + 1, board, word) ||
    //                search(i, j + 1, distance + 1, board, word);
    //        board[i][j] ^= 117;
    //        return exist;
    //    }
    public boolean exist(char[][] board, String word) {

        if (board == null) return false;
        if (word.length() == 0) return false;
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word, 0)) return true;

            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int k) {
        if (k == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || k > word.length()) {
            return false;
        }
        if (board[i][j] != word.charAt(k)) return false;
        board[i][j] ^= 256;
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int d = 0; d < 4; d++) {
            // fixes TLE
            if (dfs(board, i + dirs[d][0], j + dirs[d][1], word, k + 1)) {
                return true;
            }
        }
        board[i][j] ^= 256;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        char[][] board2 = new char[][]{
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}
        };
        WordSearch ws = new WordSearch();
        System.out.println(ws.exist(board, "ABABA"));
        System.out.println(ws.exist(board, "ABCB"));
        System.out.println(ws.exist(board2, "AAB"));
    }


}
