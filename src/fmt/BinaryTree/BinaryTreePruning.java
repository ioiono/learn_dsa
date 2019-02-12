package fmt.BinaryTree;

public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        helper(root);
        return root;
    }

    // if it can be removed
    private boolean helper(TreeNode root) {
        if (root == null) return true;

        if (root.left == null && root.right == null) return root.val == 0;

        boolean l = helper(root.left);
        boolean r = helper(root.right);
        if (l) root.left = null;

        if (r) root.right = null;

        return l && r && root.val == 0;
    }

}
