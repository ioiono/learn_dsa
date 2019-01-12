package fmt.BinaryTree;

public class SubtreeofAnotherTree {
    private boolean equals(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return p.val == q.val && equals(p.left, q.left) && equals(p.right, q.right);
    }

    private boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        return equals(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

}
