package fmt.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    /**
     * Complexity Analysis
     *
     * Time complexity : O(n).
     *
     * Space complexity : O(n).
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> list = new ArrayList<>();

        while (root != null || !s.empty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            // to leftest
            root = s.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    /**
     * Complexity Analysis
     * <p>
     * Time complexity : O(n).
     * The time complexity is O(n) because the recursive function is
     * T(n)=2⋅T(n/2)+1.
     * <p>
     * Space complexity : The worst case space required is O(n), and in the average case it's O(log(n))
     * where n is number of nodes.
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalRec(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);

        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(3);
        BinaryTreeInorderTraversal in = new BinaryTreeInorderTraversal();
        System.out.println(in.inorderTraversalRec(root));
        System.out.println(in.inorderTraversal(root));

    }
}
