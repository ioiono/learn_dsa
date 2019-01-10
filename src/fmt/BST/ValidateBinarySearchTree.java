package fmt.BST;

import java.util.Deque;
import java.util.LinkedList;

public class ValidateBinarySearchTree {
    // PS must use long here
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    public boolean isValidBSTII(TreeNode root) {
        if (root == null) return true;

        Integer min = null;

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();

            if (min != null && top.val <= min) return false;
            min = top.val;

            cur = top.right;

        }


        return true;
    }

}
