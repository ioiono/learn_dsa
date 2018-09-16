package fmt.Backtracking;

import java.util.*;

public class NQueens {
    private static int n = 10;
    private static int count = 0;

    public static void main(String[] args) {
        count = 0;
        long tic = System.currentTimeMillis();
        DFS(0, 0, 0, 0);
        long toc = System.currentTimeMillis();
        System.out.println("Total solutions: " + count);
        System.out.println("Elapsed time: " + (toc - tic) + " ms");

        System.out.println("==============================================");

        NQueens nQueens = new NQueens();
        long tic0 = System.currentTimeMillis();
        System.out.println(nQueens.solveNQueens(n).size());
        long toc0 = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (toc0 - tic0) + " ms");
        System.out.println("==============================================");

        long tic1 = System.currentTimeMillis();
        System.out.println(nQueens.solveNQueens2(n).size());
        long toc1 = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (toc1 - tic1) + " ms");

    }

    private static void DFS(int row, int shu, int pie, int na) {
        int available = ((1 << n) - 1) & ~(shu | pie | na);
        while (available != 0) {
            int p = available & -available;
            available ^= p;
            if (row == n - 1) {
                count++;
            } else {
                DFS(row + 1, shu ^ p, (pie ^ p) >> 1, (na ^ p) << 1);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList<>();
        if (n <= 0) {
            return res;
        }
        // build chessboard @mat(=matrix)
        char[][] mat = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = '.';
            }
        }
        helper(mat, 0, res);
        return res;
    }

    private void helper(char[][] mat, int row, List<List<String>> res) {
        // reach solution
        if (row == mat.length) {
            res.add(builder(mat));
            return;
        }
        for (int i = 0; i < mat.length; i++) {
            // try
            mat[row][i] = 'Q';
            // if possible
            if (isValid(mat, row, i)) {
                helper(mat, row + 1, res);
            }
            // un-try
            mat[row][i] = '.';
        }
    }

    private boolean isValid(char[][] mat, int x, int y) {
        // only check rows above current one
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < mat.length; j++) {
                // not need to check current position
                // if 'Q' in the same col or the diagonal line, return false
                if ((j == y || Math.abs(x - i) == Math.abs(y - j)) && mat[i][j] == 'Q') {
                    return false;
                }
            }
        }
        return true;
    }

    // build solution from temporary chessboard
    private List<String> builder(char[][] mat) {
        List<String> tmp = new LinkedList<>();
        for (char[] aMat : mat) {
            String t = new String(aMat);
            tmp.add(t);
        }
        return tmp;
    }

    public List<List<String>> solveNQueens2(int n) {
        List<List<String>> result = new LinkedList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        boolean[] vert = new boolean[n];
        boolean[] diag = new boolean[2 * n - 1];
        boolean[] rev = new boolean[2 * n - 1];

        helper(n, 0, result, board, vert, diag, rev);
        return result;

    }

    private void helper(int n, int row, List<List<String>> result, char[][] board, boolean[] v, boolean[] diag, boolean[] rev) {
        if (row == n) {
            String[] tmp = new String[n];
            for (int i = 0; i < n; i++) {
                tmp[i] = new String(board[i]);
            }
            result.add(Arrays.asList(tmp));
        }

        for (int col = 0; col < n; col++) {
            if (!(v[col] || diag[row - col + n - 1] || rev[row + col])) {
                v[col] = true;
                diag[row - col + n - 1] = true;
                rev[row + col] = true;
                board[row][col] = 'Q';

                helper(n, row + 1, result, board, v, diag, rev);

                v[col] = false;
                diag[row - col + n - 1] = false;
                rev[row + col] = false;
                board[row][col] = '.';
            }
        }

    }

}
