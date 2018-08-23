package fmt.NaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepthofNaryTree {
    public int maxDepthBFS(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int cnt = 0;
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                Node cur = queue.poll();
                for (Node node : cur.children) {
                    queue.offer(node);
                }
            }
            cnt++;
        }
        return cnt;
    }

    private int max = 0;

    public int maxDepthDFS(Node root) {
        if (root == null) return 0;
        dfs(root, 1);
        return max;
    }

    private void dfs(Node root, int depth) {
        if (root == null) return;
        max = Math.max(max, depth);
        for (Node node : root.children)
            dfs(node, depth + 1);
    }

    public int maxDepth(Node root) {
        if(root==null) return 0;
        int depth = 0;
        for (Node node : root.children) {
            depth = Math.max(depth, maxDepth(node));
        }
        return depth + 1;
    }


}
