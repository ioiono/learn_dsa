package fmt.BST;

public class InorderSuccessorinBST {
    /**
     * 285. Inorder Successor in BST Given a binary search tree and a node in it, find the in-order successor of that
     * node in the BST.
     * <p>
     * Note: If the given node has no in-order successor in the tree, return null.
     * <p>
     * time : O(n); space : O(n);
     *
     * @param root
     * @param p
     *
     * @return
     */

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (root.val <= p.val) {
                root = root.right;
            } else {
                res = root;
                root = root.left;
            }
        }
        return res;
    }

    public TreeNode successor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (root.val <= p.val) {
            return successor(root.right, p);
        } else {
            TreeNode temp = successor(root.left, p);
            return (temp != null) ? temp : root;
        }
    }

}
