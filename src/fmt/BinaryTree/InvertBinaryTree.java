package fmt.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);

        }
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;

        TreeNode tmp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = tmp;

        return root;

    }

    public TreeNode invertTree3(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}
