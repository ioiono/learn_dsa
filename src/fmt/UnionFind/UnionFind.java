package fmt.UnionFind;

class UnionFind {
    private int[] parents;
    private int[] ranks;

    public UnionFind(int n) {
        this.parents = new int[n + 1];
        this.ranks = new int[n + 1];
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
        return true;
    }

    public int find(int u) {
        if (parents[u] != u) {
            parents[u] = find(parents[u]);
        }
        return parents[u];
    }

    //    public int find(int u) {
    //        if (parents[u] != u) {
    //            parents[u] = find(parents[u]);
    //        }
    //        return parents[u];
    //    }
}
