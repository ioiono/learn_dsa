package fmt.BinaryTree;


/**
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 */
public class BinaryTreeMaximumPathSum {
    private int res = Integer.MIN_VALUE;
    // O(N) O(Height)
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;

        int l = Math.max(0, helper(root.left));
        int r = Math.max(0, helper(root.right));

        int sum = l + r + root.val;
        res = Math.max(res, sum);
        // second res contains the left sub-tree and right sub-tree.
        // if (left + right + node.val < maxValue ) then the result will not include the parent node which means the maximum path is in the left branch or right branch.
        return Math.max(l, r) + root.val;
    }

    public static void main(String[] args) {
        Codec cc = new Codec();
        TreeNode rt = cc.deserialize("-10,9,null,null,20,15,null,null,7,null,null");
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(rt));
    }

}
