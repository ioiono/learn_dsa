package fmt.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
///**
// * Definition for a binary tree node.
// * function TreeNode(val) {
// *     this.val = val;
// *     this.left = this.right = null;
// * }
// */
///**
// * @param {TreeNode} root
// * @return {number[]}
// */
//var postorderTraversal = function(root) {
//    if(!root) return [];
//    let res = [];
//    const l = postorderTraversal(root.left);
//    const r = postorderTraversal(root.right);
//
//    res = [...res, ...l, ...r, root.val];
//    return res;
//
//};
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {

        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.addFirst(root.val); // O(1) in linkedlist
            if (root.left != null) stack.push(root.left);
            if (root.right != null) stack.push(root.right);
        }
        return res;

    }

    public List<Integer> postorderTraversalFP(TreeNode root) {

        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;

        List<Integer> l = postorderTraversalFP(root.left);
        List<Integer> r = postorderTraversalFP(root.right);

        res.addAll(l);
        res.addAll(r);
        res.add(root.val);

        return res;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);

        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(3);
        BinaryTreePostorderTraversal b = new BinaryTreePostorderTraversal();
        System.out.println(b.postorderTraversal(root));
        System.out.println(b.postorderTraversalFP(root));

    }
}
