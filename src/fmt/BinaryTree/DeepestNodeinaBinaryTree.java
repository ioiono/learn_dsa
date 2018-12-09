package fmt.BinaryTree;

public class DeepestNodeinaBinaryTree {
    int deepestlevel;
    int value;

    public int Deep(TreeNode root) {
        find(root, 0);
        return value;
    }

    public void find(TreeNode root, int level) {
        if (root != null) {
            System.out.println("left " + (level+1));
            find(root.left, ++level);
            if (level > deepestlevel) {
                value = root.val;
                deepestlevel = level;
            }
            System.out.println("right " + level);
            find(root.right, level);
        }
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        DeepestNodeinaBinaryTree dp = new DeepestNodeinaBinaryTree();
        System.out.println("Deepest child is: " + dp.Deep(root));

    }
}
