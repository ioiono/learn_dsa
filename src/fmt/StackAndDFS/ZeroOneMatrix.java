package fmt.StackAndDFS;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

    class Cell {
        int x;
        int y;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    // BFS when the val == 0
    public int[][] updateMatrix(int[][] matrix) {

        if (matrix == null) return null;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Queue<Cell> que = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    que.offer(new Cell(i, j));
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while (!que.isEmpty()) {
            Cell cur = que.poll();
            int x = cur.x;
            int y = cur.y;
            for (int i = 0; i < 4; i++) {
                add(matrix, x + dirs[i][0], y + dirs[i][1], que, matrix[x][y] + 1);
            }
        }
        return matrix;
    }

    void add(int[][] matrix, int i, int j, Queue<Cell> que, int dis) {
        int m = matrix.length, n = matrix[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] <= dis) return;
        matrix[i][j] = dis;
        que.offer(new Cell(i, j));
    }

    public static void main(String[] args) {
        ZeroOneMatrix zom = new ZeroOneMatrix();
        System.out.println(Arrays.deepToString(zom.updateMatrix(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        })));
        System.out.println(Arrays.deepToString(zom.updateMatrix(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        })));
    }
}
