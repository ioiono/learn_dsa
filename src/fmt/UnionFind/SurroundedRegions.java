package fmt.UnionFind;

public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        UnionFind unionFind = new UnionFind(m * n + 1);
        int dummy = m * n;
        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    continue;
                }
                int curr = i * n + j;
                // Merging the edge with the virtual dummy position
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    unionFind.union(curr, dummy);
                    continue;
                }
                // If edge is 'O', union them.
                for (int k = 0; k < dirs.length; k++) {
                    int x = i + dirs[k][0];
                    int y = j + dirs[k][1];

                    if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {
                        unionFind.union(curr, x * n + y);
                    }
                }
            }
        }

        // Assign 'X'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && unionFind.find(i * n + j) != unionFind.find(dummy)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    // DFS
    // Runtime: 4 ms, faster than 100.00% of Java online submissions for Surrounded Regions.
    public void solve2(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0)
            return;
        int height = board.length, width = board[0].length;

        for (int i = 0; i < width; i++) {
            dfs(board, 0, i);
            dfs(board, height - 1, i);
        }
        for (int i = 0; i < height; i++) {
            dfs(board, i, 0);
            dfs(board, i, width - 1);
        }
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                board[i][j] = board[i][j] == 'V' ? 'O' : 'X';
        return;
    }
    public void dfs(char[][] board, int row, int col) {
        int height = board.length, width = board[0].length;
        if (row < 0 || row >= height || col < 0 || col >= width || board[row][col] != 'O')
            return;
        board[row][col] = 'V'; // visited
        dfs(board, row - 1, col);
        dfs(board, row, col - 1);
        dfs(board, row + 1, col);
        dfs(board, row, col + 1);
    }

    public static void main(String[] args) {

    }
}
