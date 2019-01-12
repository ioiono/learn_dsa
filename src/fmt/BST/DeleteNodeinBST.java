package fmt.BST;

public class DeleteNodeinBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) root.left = deleteNode(root.left, key);
        else if (root.val < key) root.right = deleteNode(root.right, key);
        else { // found node to be deleted
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            // node with two children, replace with the inOrder successor(minVal) in the right subtree
            root.val = getMin(root.right);
            // do not forget to remove val in the right subtree
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private int getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(TreeUtils.inorderTraversal(root));
        DeleteNodeinBST de = new DeleteNodeinBST();
        de.deleteNode(root, 3);

        System.out.println(TreeUtils.inorderTraversal(root));
    }


}
