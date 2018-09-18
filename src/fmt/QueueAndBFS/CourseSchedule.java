package fmt.QueueAndBFS;

import java.util.ArrayList;

// topological sort
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; ++i)
            graph.add(new ArrayList<>());

        for (int i = 0; i < prerequisites.length; ++i) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];
            graph.get(course).add(prerequisite);
        }

        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; ++i)
            if (dfs(i, graph, visited))
                return false;

        return true;
    }

    private boolean dfs(int curr, ArrayList<ArrayList<Integer>> graph, int[] visited) {
        if (visited[curr] == 1) return true;
        if (visited[curr] == 2) return false;

        visited[curr] = 1;

        for (int next : graph.get(curr))
            if (dfs(next, graph, visited)) return true;

        visited[curr] = 2;
        return false;
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        boolean[] marked = new boolean[numCourses];
        boolean[] onStack = new boolean[numCourses];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; ++i)
            graph.add(new ArrayList<>());


        for (int i = 0; i < prerequisites.length; ++i) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];
            graph.get(course).add(prerequisite);
        }

        for (int v = 0; v < numCourses; v++) {
            if (dfs(marked, onStack, graph, v)) {
                return false;
            }
        }

        return true;
    }

    // whether could find a cycle
    private boolean dfs(boolean[] marked,
                        boolean[] onStack,
                        ArrayList<ArrayList<Integer>> graph,
                        int v) {
        if (onStack[v]) {
            return true;
        }
        onStack[v] = true;
        marked[v] = true;
        for (int w : graph.get(v)) {
            // found new vertex, so recur
            if (!marked[w]) {
                dfs(marked, onStack, graph, w);
            }
            // trace back directed cycle
            else if (onStack[w]) {
                return true;
            }
        }
        onStack[v] = false;
        return false;
    }

    public static void main(String[] args) {
//                int n = 2;
//                int[][] p = new int[][]{{1, 0}, {0, 1}};
        int n = 4;
        int[][] p = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        CourseSchedule cs = new CourseSchedule();
        System.out.println(cs.canFinish(n, p));
        System.out.println(cs.canFinish2(n, p));

    }

}
