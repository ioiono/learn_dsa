package fmt.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, sum, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode root, int cur, List<Integer> path, List<List<Integer>> res) {
        if (root == null) return;

        path.add(root.val);
        if (root.left == null && root.right == null && cur == root.val) { // leaf node
            res.add(new ArrayList<>(path)); // copy of path
        }
        if (root.left != null)    dfs(root.left, cur - root.val, path, res);
        if (root.right != null)   dfs(root.right, cur - root.val, path, res);
        path.remove(path.size() - 1);
    }
}
