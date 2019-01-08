package fmt.BinaryTree;

public class DiameterofBinaryTree {
    private int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }

    public int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L + R);
        return Math.max(L, R) + 1;
    }

}
