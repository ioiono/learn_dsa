package fmt.HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following
 * rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * <p>
 * Each column must contain the digits 1-9 without repetition.
 * <p>
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 */
public class ValidSudoku {

    // time : O(n^2) space : O(n)
    public boolean isValidSudoku1(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) return false;
                if (board[j][i] != '.' && !cols.add(board[j][i])) return false;

                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);

                if (board[rowIndex + j / 3][colIndex + j % 3] != '.' && !cube.add(board[rowIndex + j / 3][colIndex + j % 3]))
                    return false;
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;
                if (!valid(board, i, j)) return false;
            }
        }
        return true;
    }

    public boolean valid(char[][] board, int i, int j) {
        for (int row = 0; row < board.length; row++) {
            if (row == i) continue;
            if (board[row][j] == board[i][j]) return false;
        }
        for (int col = 0; col < board[0].length; col++) {
            if (col == i) continue;
            if (board[i][col] == board[i][j]) return false;
        }
        for (int row = (i / 3) * 3; row < (i / 3 + 1) * 3; row++) {
            for (int col = (j / 3) * 3; col < (j / 3 + 1) * 3; col++) {
                if (row == i && col == j) continue;
                if (board[row][col] == board[i][j]) return false;
            }
        }
        return true;
    }


    // 666
    // https://leetcode.com/problems/valid-sudoku/discuss/15472/shortsimple-java-using-strings

    /**
     * Collect the set of things we see, encoded as strings. For example:
     * <p>
     * '4' in row 7 is encoded as "(4)7". '4' in column 7 is encoded as "7(4)". '4' in the top-right block is encoded as
     * "0(4)2". Scream false if we ever fail to add something because it was already added (i.e., seen before).
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku666(char[][] board) {
        Set seen = new HashSet();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";
                    if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i / 3 + b + j / 3))
                        return false;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku6662(char[][] board) {
        Set<String> seen = new HashSet();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i / 3 + "-" + j / 3))
                        return false;
            }
        }
        return true;
    }

    // tricky
    public boolean isValidSudoku(char[][] board) {
        int[] vset = new int[9];
        int[] hset = new int[9];
        int[] bckt = new int[9];
        int idx = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    idx = 1 << (board[i][j] - '0');
                    if ((hset[i] & idx) > 0 || (vset[j] & idx) > 0 || (bckt[(i / 3) * 3 + j / 3] & idx) > 0)
                        return false;
                    hset[i] |= idx;
                    vset[j] |= idx;
                    bckt[(i / 3) * 3 + j / 3] |= idx;
                }
            }
        }
        return true;
    }
}
