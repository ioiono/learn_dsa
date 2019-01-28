package fmt.UnionFind;


import java.util.ArrayList;
import java.util.List;

public class NumberofConnectedComponentsinanUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        if (n <= 1) return n;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int cnt = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                cnt++;
                dfs(i, adjList, visited);
            }
        }
        return cnt;

    }

    private void dfs(int i, List<List<Integer>> adjList, boolean[] visited) {
        visited[i] = true;
        for (int edge : adjList.get(i)) {
            if (!visited[edge]) {
                dfs(edge, adjList, visited);
            }
        }
    }

    public int countComponentsUF(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) uf.union(edge[0], edge[1]);
        return uf.count();
    }


    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        int n = 5;
        NumberofConnectedComponentsinanUndirectedGraph cc = new NumberofConnectedComponentsinanUndirectedGraph();

        System.out.println(cc.countComponents(n, edges));
        System.out.println(cc.countComponentsUF(n, edges));

    }
}
