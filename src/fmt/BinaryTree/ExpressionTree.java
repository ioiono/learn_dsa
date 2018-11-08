package fmt.BinaryTree;

/**
 * This problem was asked by Microsoft.
 *
 * Suppose an arithmetic expression is given as a binary tree. Each leaf is an integer and each internal node is one
 * of '+', '−', '∗', or '/'.
 *
 * Given the root to such a tree, write a function to evaluate it.
 *
 * For example, given the following tree:
 *
 *     *
 *    / \
 *   +    +
 *  / \  / \
 * 3  2  4  5
 * You should return 45, as it is (3 + 2) * (4 + 5).
 */
public class ExpressionTree {
    public int evalTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // int
        if (root.left == null && root.right == null) {
            return root.val;
        }

        int l = evalTree(root.left);
        int r = evalTree(root.right);

        if (root.val == '+') return l + r;
        if (root.val == '-') return l - r;
        if (root.val == '*') return l * r;

        return l / r;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode('*');
        root.left = new TreeNode('+');
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode('+');
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        ExpressionTree e = new ExpressionTree();
        System.out.println(e.evalTree(root));

    }
}
