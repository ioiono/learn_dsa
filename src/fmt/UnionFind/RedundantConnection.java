package fmt.UnionFind;

import java.util.*;

// Runtime: 3 ms, faster than 97.46% of Java online submissions for Redundant Connection.
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

/**
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 *
 * The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
 *
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.
 *
 * Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.
 *
 * Example 1:
 * Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given undirected graph will be like this:
 *   1
 *  / \
 * 2 - 3
 * Example 2:
 * Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * Output: [1,4]
 * Explanation: The given undirected graph will be like this:
 * 5 - 1 - 2
 *     |   |
 *     4 - 3
 * Note:
 * The size of the input 2D-array will be between 3 and 1000.
 * Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
 */
public class RedundantConnection {
    // Using Union-Find
    // O(nlog*n) -> O(N)
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);

        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return null;
    }

    // Using DFS
    // O(N^2)
    public int[] findRedundantConnection2(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 1001; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int p = edge[0], v = edge[1];
            if (dfs(adj, p, v, new HashSet<>())) return edge;
            adj.get(p).add(v);
            adj.get(v).add(p);
        }
        return new int[0];
    }
    // already has path from start to end?
    public boolean dfs(List<List<Integer>> adj, int start, int end, Set<Integer> visited) {
        if (start == end) return true; // find it!
        visited.add(start);
        for (int next : adj.get(start)) {
            if (visited.contains(next)) continue;
            if (dfs(adj, next, end, visited)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {1, 2}, {1, 3}, {2, 3}
        };
        RedundantConnection rc = new RedundantConnection();
        System.out.println(Arrays.toString(rc.findRedundantConnection(edges)));
        System.out.println(Arrays.toString(rc.findRedundantConnection2(edges)));
    }
}
