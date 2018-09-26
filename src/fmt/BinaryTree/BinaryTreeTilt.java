package fmt.BinaryTree;

public class BinaryTreeTilt {
    private int res = 0;
    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;

        int l = helper(root.left);
        int r = helper(root.right);

        res += Math.abs(l - r);
        return root.val + l + r;
    }

    public static void main(String[] args) {
        Codec cc = new Codec();
        TreeNode rt = cc.deserialize("1,2,3,null,null,4,null,null,5,null,null,");
        System.out.println(new BinaryTreeTilt().findTilt(rt));
    }
}
