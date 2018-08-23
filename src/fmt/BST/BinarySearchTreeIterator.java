package fmt.BST;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a
 * BST.
 * <p>
 * Calling next() will return the next smallest number in the BST.
 * <p>
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        this.pushNodes(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmp = stack.pop();
        this.pushNodes(tmp.right);
        return tmp.val;
    }

    private void pushNodes(TreeNode root) {
        for (; root != null; stack.push(root), root = root.left) ;

    }
}
//
//public class BSTIterator {
//
//    private TreeNode visit;
//    private Stack<TreeNode> stack;
//
//    public BSTIterator(TreeNode root) {
//        visit = root;
//        stack = new Stack();
//    }
//
//    public boolean hasNext() {
//        return visit != null || !stack.empty();
//    }
//
//    public int next() {
//        while (visit != null) {
//            stack.push(visit);
//            visit = visit.left;
//        }
//        TreeNode next = stack.pop();
//        visit = next.right;
//        return next.val;
//    }
//}

public class BinarySearchTreeIterator {
    public static void main(String[] args) {
        BSTIterator i = new BSTIterator(new TreeNode(1));
        while (i.hasNext()) {

        }
    }
}
