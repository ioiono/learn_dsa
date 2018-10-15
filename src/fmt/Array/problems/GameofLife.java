package fmt.Array.problems;

import java.util.Arrays;

public class GameofLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int lives = 0;
                // Scan the 3x3 region including (j, i).
                for (int y = Math.max(0, i - 1); y < Math.min(m, i + 2); ++y)
                    for (int x = Math.max(0, j - 1); x < Math.min(n, j + 2); ++x)
                        lives += board[y][x] & 1;
                if (lives == 3 || lives - board[i][j] == 3) board[i][j] |= 0b10;
            }
        }
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                board[i][j] >>= 1;
    }

    public static void main(String[] args) {
        int[][] game = new int[][]{
                {1, 0, 0},
                {1, 1, 0},
                {1, 0, 0}
        };

        new GameofLife().gameOfLife(game);
        System.out.println(Arrays.deepToString(game));
    }
}
