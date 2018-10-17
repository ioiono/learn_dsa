package fmt.UnionFind;

import java.util.HashSet;
import java.util.Set;

class UF {
    private int[] parents;
    private int[] ranks;
    private int cnt;

    public UF(int n) {
        this.cnt = n;
        this.parents = new int[n];
        this.ranks = new int[n];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }
    }

    public boolean union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU == rootV) return false;
        if (ranks[rootV] > ranks[rootU]) {
            parents[rootU] = rootV;
        } else if (ranks[rootU] > ranks[rootV]) {
            parents[rootV] = rootU;
        } else {
            parents[rootV] = rootU;
            ranks[rootU]++;
        }
        this.cnt--;
        return true;
    }

    public int find(int u) {
        if (parents[u] != u) {
            parents[u] = find(parents[u]);
        }
        return parents[u];
    }

    public int count() {
        return this.cnt;
    }
}

public class FriendCircles {


    public int findCircleNum(int[][] M) {
        int n = M.length;
        UF uf = new UF(n);
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

    private void dfs(int[][] M, int index, boolean[] visited) {
        if (visited[index]) return;
        visited[index] = true;
        for (int j = 0; j < visited.length; j++) {
            if (M[index][j] == 1 && !visited[j]) {
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
