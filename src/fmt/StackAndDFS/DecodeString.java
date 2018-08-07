package fmt.StackAndDFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Cell {
    int x;
    int y;

    Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor != newColor) dfs(image, sr, sc, oldColor, newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int oldColor, int newColor) {
        int m = image.length;
        int n = image[0].length;
        if (sr < 0 || sr >= m || sc < 0 || sc >= n || image[sr][sc] != oldColor) {
            return;
        }
        image[sr][sc] = newColor;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int[] dir : dirs) {
            dfs(image, sr + dir[0], sc + dir[1], oldColor, newColor);
        }
    }

    public int[][] floodFillBFS(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) return image;

        Queue<Cell> que = new LinkedList<>();

        que.offer(new Cell(sr, sc));
        image[sr][sc] = newColor;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!que.isEmpty()) {
            Cell tmp = que.poll();
            int x = tmp.x;
            int y = tmp.y;
            for (int k = 0; k < 4; k++) {
                addToQueue(x + dirs[k][0], y + dirs[k][1], image, que, newColor, oldColor);
            }
        }
        return image;
    }

    private void addToQueue(int x, int y, int[][] image, Queue<Cell> queue, int newColor, int oldColor) {

        if (x < 0 || x >= image.length ||
                y < 0 || y >= image[0].length ||
                image[x][y] != oldColor) {
            return;
        }
        queue.offer(new Cell(x, y));
        image[x][y] = newColor;
    }

}

public class DecodeString {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.floodFill(new int[][]{{1, 1, 1, 1}, {1, 1, 0, 1}, {1, 1, 0, 0}, {1, 0, 0, 1}}, 1, 1, 2)));
        System.out.println(Arrays.deepToString(s.floodFillBFS(new int[][]{{1, 1, 1, 1}, {1, 1, 0, 1}, {1, 1, 0, 0}, {1, 0, 0, 1}}, 1, 1, 2)));
    }
}
