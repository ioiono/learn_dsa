package fmt.BinaryTree;

public class DistributeCoinsinBinaryTree {
    private int res = 0;

    public int distributeCoins(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        res += Math.abs(l) + Math.abs(r);
        return l + r + root.val - 1;
    }
}
