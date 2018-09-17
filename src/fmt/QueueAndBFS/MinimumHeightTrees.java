package fmt.QueueAndBFS;

import java.util.*;

/**
 * For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a
 * rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given
 * such a graph, write a function to find all the MHTs and return a list of their root labels.
 * <p>
 * Format The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of
 * undirected edges (each edge is a pair of labels).
 * <p>
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as
 * [1, 0] and thus will not appear together in edges.
 * <p>
 * Example 1 :
 * <p>
 * Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 * <p>
 * 0 | 1 / \ 2   3
 * <p>
 * Output: [1] Example 2 :
 * <p>
 * Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 * <p>
 * 0  1  2 \ | / 3 | 4 | 5
 * <p>
 * Output: [3, 4] Note:
 * <p>
 * According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are
 * connected by exactly one path. In other words, any connected graph without simple cycles is a tree.” The height of a
 * rooted tree is the number of edges on the longest downward path between the root and a leaf.
 */
public class MinimumHeightTrees {
    // 44ms
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }


        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            if (adj.get(i).size() == 1) leaves.add(i);

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }

    // 6ms 100%
    public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            return result;
        }
        int[] indegrees = new int[n];
        int[] connected = new int[n];
        for (int[] e : edges) {
            indegrees[e[0]]++;
            indegrees[e[1]]++;
            connected[e[0]] ^= e[1];
            connected[e[1]] ^= e[0];
        }
        System.out.println(Arrays.toString(connected));
        Queue<Integer> queue = new LinkedList<>();
        //Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 1) queue.offer(i);
        }
        while (n > 2) {
            int size = queue.size();
            n -= size;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                int neighbor = connected[cur];
                indegrees[cur]--;
                indegrees[neighbor]--;
                // remove edge
                connected[neighbor] ^= cur;
                if (indegrees[neighbor] == 1) {
                    queue.offer(neighbor);
                }
            }
        }
        while (!queue.isEmpty()) result.add(queue.poll());
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = new int[][]{{1, 0}, {1, 2}, {1, 3}};
        int n2 = 6;
        int[][] edges2 = new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};

        MinimumHeightTrees MHT = new MinimumHeightTrees();

        System.out.println(MHT.findMinHeightTrees(n, edges));
        System.out.println(MHT.findMinHeightTrees2(n, edges));
        System.out.println(MHT.findMinHeightTrees(n2, edges2));
        System.out.println(MHT.findMinHeightTrees2(n2, edges2));

    }
}
