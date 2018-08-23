package fmt.BST;

public class SearchinaBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }

    public TreeNode searchBSTIter(TreeNode root, int val) {
        if (root == null) return null;

        while (root != null) {
            if (root.val == val) return root;

            if (root.val < val) root = root.right;
            else root = root.left;
        }

        return null;
    }
}
