package fmt.BinaryTree;

import java.util.Stack;

/**
 * Find the sum of all left leaves in a given binary tree.
 * <p>
 * Example:
 * <p>
 * 3 / \ 9  20 /  \ 15   7
 * <p>
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24[.
 */
public class SumofLeftLeaves {
    private int res = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null)
                res += root.left.val;
            helper(root.left);
        }
        if (root.right != null) {
            helper(root.right);
        }
    }
    // Iterative method. Here for each node in the tree we check whether its left child is a leaf.
    // If it is true, we add its value to answer, otherwise add left child to the stack to process it later. For
    // right child we add it to stack only if it is not a leaf.

    public int sumOfLeftLeavesIter(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while ( !stack.empty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null)
                    ans += node.left.val;
                else
                    stack.push(node.left);
            }
            if (node.right != null) {
                if (node.right.left != null || node.right.right != null)
                    stack.push(node.right);
            }
        }
        return ans;
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return 0;
        return helper2(root);
    }

    private int helper2(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;

        int l = helper2(root.left);
        if (root.right != null && root.right.left == null && root.right.right == null) return l;

        int r = helper2(root.right);
        return l + r;
    }

    public static void main(String[] args) {
        Codec cc = new Codec();
        TreeNode root = cc.deserialize("3,9,null,null,20,15,null,null,7,null,null,");
        SumofLeftLeaves sum = new SumofLeftLeaves();

        System.out.println(sum.sumOfLeftLeaves(root));
        System.out.println(sum.sumOfLeftLeaves2(root));
        System.out.println(sum.sumOfLeftLeavesIter(root));
    }
}
