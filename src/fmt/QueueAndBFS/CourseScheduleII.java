package fmt.QueueAndBFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] marked = new boolean[numCourses];
        boolean[] onStack = new boolean[numCourses];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; ++i)
            graph.add(new ArrayList<>());

        for (int[] prerequisite1 : prerequisites) {
            int course = prerequisite1[0];
            int prerequisite = prerequisite1[1];
            graph.get(prerequisite).add(course);
        }

        Stack<Integer> stack = new Stack<>();
        for (int v = 0; v < numCourses; v++) {
            if (!marked[v] && dfs(marked, onStack, graph, v, stack)) {
                return new int[0];
            }
        }
        if (stack.size() < numCourses) return new int[0];
        int[] orderArray = new int[graph.size()];
        for (int i = 0; i < numCourses; i++) orderArray[i] = stack.pop();
        return orderArray;
    }

    private boolean dfs(boolean[] marked,
                        boolean[] onStack,
                        ArrayList<ArrayList<Integer>> graph,
                        int v,
                        Stack<Integer> list) {

        onStack[v] = true;
        marked[v] = true;

        for (int w : graph.get(v)) {
            // found new vertex, so recur
            if (!marked[w]) {
                dfs(marked, onStack, graph, w, list);
            }
            // has directed cycle
            else if (onStack[w]) {
                return true;
            }
        }
        list.add(v);
        onStack[v] = false;
        return false;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] p = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        //        int n = 2;
        //        int[][] p = new int[][]{{0, 1}};
        CourseScheduleII cs2 = new CourseScheduleII();
        System.out.println(Arrays.toString(cs2.findOrder(n, p)));
    }
}
