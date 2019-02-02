package fmt.BinaryTree;

public class BinaryTreeMaximumPathSumFromLeafToRoot {
    // O(N) O(Height)
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        return helper(root);
    }

    /**
     * For example, the minimum path in this tree is [10, 5, 1, -1], which has sum 15.
     *
     *   10
     *  /  \
     * 5    5
     *  \     \
     *    2    1
     *        /
     *      -1
     * @param root root
     * @return min
     */
    public int minPathSum(TreeNode root) {
        if (root == null) return 0;
        return helper2(root);
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;

        int l = Math.max(0, helper(root.left));
        int r = Math.max(0, helper(root.right));

        return Math.max(l, r) + root.val;
    }

    // FOR MINIMUM PATH SUM
    private int helper2(TreeNode root) {
        if (root == null) return 0;

        int l = helper2(root.left);
        int r = helper2(root.right);

        return Math.min(l, r) + root.val;
    }


    public static void main(String[] args) {
        Codec cc = new Codec();
        TreeNode rt2 = cc.deserialize("10,5,null,2,null,null,5,null,1,-1,null,null,null");
        BinaryTreeMaximumPathSumFromLeafToRoot b = new BinaryTreeMaximumPathSumFromLeafToRoot();
        System.out.println(b.minPathSum(rt2));
        System.out.println(b.maxPathSum(rt2));
    }
}
