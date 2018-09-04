package fmt.Array.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix == null) return;

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        int r = 0;
        int c = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int row : rows) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[row][i] = 0;
            }
        }
        for (int col : cols) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
        return;

    }
    // fr = first row
    // fc = first col

    // Use first row and first column as markers.
    // if matrix[i][j] = 0, mark respected row and col marker = 0; indicating
    // that later this respective row and col must be marked 0;
    // PS HERE.. ALTERING leads to two vars to track their own state
    // And because you are altering first row and column,
    // you need to  have two variables to track their own status.
    // So, for ex, if any one of the first row is 0, fr = 0,
    // and at the end set all first row to 0;
    public void setZeroes2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row = false;
        boolean col = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    if (i == 0) row = true;
                    if (j == 0) col = true;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5},
        };
        int[][] m1 = new int[][]{{0, 0, 0, 5}, {4, 3, 1, 4}, {0, 1, 1, 4}, {1, 2, 1, 3}, {0, 0, 1, 1}};
        SetMatrixZeroes smz = new SetMatrixZeroes();
        System.out.println(Arrays.deepToString(m1));
        smz.setZeroes(m1);
        System.out.println(Arrays.deepToString(m1));

    }

}
