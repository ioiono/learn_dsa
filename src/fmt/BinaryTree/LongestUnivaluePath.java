package fmt.BinaryTree;

public class LongestUnivaluePath {
    private int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        int leftSum = 0;
        int rightSum = 0;
        if (root.left != null && root.left.val == root.val) {
            leftSum += l + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            rightSum += r + 1;
        }
        res = Math.max(res, leftSum + rightSum);
        return Math.max(leftSum, rightSum);
    }

    public static void main(String[] args) {
        Codec cc = new Codec();
        TreeNode rt = cc.deserialize("1,4,4,null,null,4,null,null,5,null,5,null,null,");
        TreeNode rt2 = cc.deserialize("5,4,1,null,null,1,null,null,5,null,5,null,null,");
        System.out.println(new LongestUnivaluePath().longestUnivaluePath(rt));
        System.out.println(new LongestUnivaluePath().longestUnivaluePath(rt2));
    }
}
