package fmt.queueAndBFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a m x n 2D grid initialized with these three possible values.
 * <p>
 * -1 - A wall or an obstacle.
 * <p>
 * 0 - A gate.
 * <p>
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the
 * distance to a gate is less than 2147483647. Fill each empty room with the distance to its nearest gate. If it is
 * impossible to reach a gate, it should be filled with INF.
 */
public class WallsAndGates {
    class Cell {
        int x;
        int y;
        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        int[][] moves = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<Cell> queue = new LinkedList<>();

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new Cell(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Cell cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            for (int i = 0; i < 4; i++) {
                addToQueue(x + moves[i][0], y + moves[i][1], rooms, queue, rooms[x][y] + 1);
            }
        }

    }

    private void addToQueue(int x, int y, int[][] rooms, Queue<Cell> queue, int steps) {
        if (x < 0 || x >= rooms.length ||
                y < 0 || y >= rooms[0].length ||
                rooms[x][y] == -1 ||
                rooms[x][y] != Integer.MAX_VALUE) { //has been visited or 0
            return;
        }
        rooms[x][y] = steps;
        queue.add(new Cell(x, y));
    }

    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE;
        int[][] ints = new int[][]{
                {INF, -1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF},
        };

        System.out.println(Arrays.deepToString(ints));
        WallsAndGates wag = new WallsAndGates();
        wag.wallsAndGates(ints);
        System.out.println(Arrays.deepToString(ints));

    }

}
