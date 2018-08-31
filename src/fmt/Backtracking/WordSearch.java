package fmt.Backtracking;

public class WordSearch {
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
