package fmt.UnionFind;

import java.util.HashSet;
import java.util.Set;

public class FriendCircles {


    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.count();
    }

    public int findCircleNum2(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) uf.union(i, j);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(uf.find(i));
        }
        return set.size();
    }

    // DFS
    public int findCircleNum3(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int circle = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                circle++;
                dfs(M, i, visited);
            }
        }
        return circle;
    }

    private void dfs(int[][] M, int i, boolean[] visited) {
//        if (visited[index]) return;
        visited[i] = true;
        for (int j = 0; j < visited.length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                dfs(M, j, visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] M = new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1},
        };
        int[][] M1 = new int[][]{
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1},
        };
        FriendCircles fc = new FriendCircles();
        System.out.println(fc.findCircleNum(M));
        System.out.println(fc.findCircleNum2(M));
        System.out.println(fc.findCircleNum3(M));
        System.out.println(fc.findCircleNum(M1));
        System.out.println(fc.findCircleNum2(M1));
        System.out.println(fc.findCircleNum3(M1));
    }
}
