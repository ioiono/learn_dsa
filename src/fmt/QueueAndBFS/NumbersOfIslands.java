package fmt.QueueAndBFS;

import java.util.LinkedList;
import java.util.Queue;

public class NumbersOfIslands {

    /**
     * DFS O(mn)
     *
     * @param grid islands
     * @return number of islands
     */
    private int numIslandsDFS(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == '1') {
                    merge(grid, i, j);
                    count++;
                }

        return count;
    }

    private void merge(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') // ps last condition, must equal to 1 then expand
            return;

        grid[i][j] = '0';

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : dirs) {
            merge(grid, i + dir[0], j + dir[1]);
        }
//        merge(grid, i - 1, j);
//        merge(grid, i + 1, j);
//        merge(grid, i, j - 1);
//        merge(grid, i, j + 1);
    }

    ////////////////////////////////////////////////////////////////////


    class Cell {
        int x;
        int y;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int numIslandsBFS(char[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int cnt = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void bfs(char[][] grid, int i, int j) {
        Queue<Cell> queue = new LinkedList<>();
        queue.offer(new Cell(i, j));
        grid[i][j] = '0';
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!queue.isEmpty()) {
            Cell tmp = queue.poll();
            int x = tmp.x;
            int y = tmp.y;
            for (int k = 0; k < 4; k++) {
                addToQueue(x + dirs[k][0], y + dirs[k][1], grid, queue);
            }
        }

    }

    private void addToQueue(int x, int y, char[][] grid, Queue<Cell> queue) {
        if (x < 0 || x >= grid.length ||
                y < 0 || y >= grid[0].length ||
                grid[x][y] == '0') {
            return;
        }
        queue.offer(new Cell(x, y));
        grid[x][y] = '0';


    }

    public static void main(String[] args) {
        char[][] island = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        char[][] island2 = new char[][]{
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '1'}
        };
        NumbersOfIslands noi = new NumbersOfIslands();
        System.out.println(noi.numIslandsDFS(island));
        System.out.println(noi.numIslandsDFS(island2));

//        System.out.println(noi.numIslandsBFS(island));
//        System.out.println(noi.numIslandsBFS(island2));

    }
}
