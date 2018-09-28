package fmt.BST;

import java.util.Stack;

public class MinimumAbsoluteDifferenceinBST {
    public int getMinimumDifferenceIter(TreeNode root) {
        // inorder
        if (root == null) return 0;
        Stack<TreeNode> s = new Stack<>();
        int min = Integer.MAX_VALUE;
        Integer pre = null;
        while (root != null || !s.empty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if (pre != null) min = Math.min(min, Math.abs(root.val - pre));
            pre = root.val;
            root = root.right;
        }
        return min;
    }

    private TreeNode prev;
    private int ans = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        getMinimumDifference(root.left);
        if (prev != null) ans = Math.min(ans, root.val - prev.val);
        prev = root;
        getMinimumDifference(root.right);
        return ans;
    }
}
