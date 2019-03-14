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

    // slower of mine
    public int diameterOfBinaryTree2(TreeNode root) {
        if (root == null) return 0;
        int l = diameterOfBinaryTree2(root.left);
        int r = diameterOfBinaryTree2(root.right);
        int larger = Math.max(l, r);
        return Math.max(larger, height(root.left) + height(root.right));
    }

    private int height(TreeNode root) {
        if (root == null) return 0;

        int l = height(root.left);
        int r = height(root.right);

        return 1 + Math.max(l, r);
    }

}
