package fmt.BinaryTree;

public class CountUnivalueSubtrees {
    /**
     * Given a binary tree, count the number of uni-value subtrees.

     A Uni-value subtree means all nodes of the subtree have the same value.

     For example:
     Given binary tree,
         5
        / \
       1   5
      / \   \
     5  5   5
     return 4.

     root = 5 res = 2
     root = 1
     root = 5 res = 3
     root = 5 res = 4

     time : O(n)
     space : O(n)


     */


    int res;

    public int countUnivalSubtrees(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }

    // returns true if subtrees under root is single
    public boolean helper(TreeNode root) {
        if (root == null) return true;

        boolean left = helper(root.left);
        boolean right = helper(root.right);

        if (left && right) {
            if (root.left != null && root.val != root.left.val) {
                return false;
            }
            if (root.right != null && root.val != root.right.val) {
                return false;
            }
            res++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(5);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);

        System.out.println(new CountUnivalueSubtrees().countUnivalSubtrees(root));
    }

}
