package fmt.StackAndDFS;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTInorder {
    private List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    private void helper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        helper(res, root.left);
        res.add(root.val);
        helper(res, root.right);
    }


    private List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        BTInorder bi = new BTInorder();
        System.out.println(bi.inorderTraversal(root));
        System.out.println(bi.inorderTraversal2(root));
        System.out.println(bi.inorderTraversal(null));
        System.out.println(bi.inorderTraversal2(null));
    }

}
