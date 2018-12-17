package fmt.BinaryTree;

public class FlipEquivalentBinaryTrees {
    public boolean flipEquiv(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        boolean l1 = flipEquiv(p.left, q.left);
        boolean r1 = flipEquiv(p.right, q.right);

        boolean l2 = flipEquiv(p.left, q.right);
        boolean r2 = flipEquiv(p.right, q.left);

        return ((l1 && r1) || (l2 && r2));
    }


}
