package fmt.BinaryTree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversalRec(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    void helper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode visiting = stack.pop();
            list.add(visiting.val);
            if (visiting.right != null) stack.push(visiting.right);
            if (visiting.left != null) stack.push(visiting.left);
        }
        return list;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);

        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(3);
        BinaryTreePreorderTraversal b = new BinaryTreePreorderTraversal();
        System.out.println(b.preorderTraversalRec(root));
        System.out.println(b.preorderTraversal(root));

    }
}
