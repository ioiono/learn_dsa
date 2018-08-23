package fmt.BST;

public class InsertintoaBinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val > val) root.left = insertIntoBST(root.left, val);
        else root.right = insertIntoBST(root.right, val);

        return root;
    }

    public TreeNode insertIntoBSTIter(TreeNode root, int val) {
        TreeNode cur = root;
        TreeNode node = new TreeNode(val);
        while (cur != null) {
            if (cur.val > val) {
                if (cur.left == null) {
                    cur.left = node;
                    break;
                } else {
                    cur = cur.left;
                }
            } else {
                if (cur.right == null) {
                    cur.right = node;
                    break;
                } else {
                    cur = cur.right;
                }
            }
        }
        return root;
    }

}
