package fmt.BinaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthofBinaryTree {
    private int answer = 0;        // don't forget to initialize answer before call maximum_depth

    //"Top-down" Solution
    private void maximum_depth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            answer = Math.max(answer, depth);
        }
        maximum_depth(root.left, depth + 1);
        maximum_depth(root.right, depth + 1);
    }

    // use this
    //"Bottom-up" Solution
    public int maximum_depth(TreeNode root) {
        if (root == null) return 0;                      // return 0 for null node
        int left_depth = maximum_depth(root.left);
        int right_depth = maximum_depth(root.right);
        return Math.max(left_depth, right_depth) + 1;    // return depth of the subtree rooted at root
    }

    /**
     * Conclusion It is not easy to understand recursion and find out a recursion solution for the problem. When you
     * meet a tree problem, ask yourself two questions: can you determine some parameters to help the node know the
     * answer of itself? Can you use these parameters and the value of the node itself to determine what should be the
     * parameters parsing to its children? If the answers are both yes, try to solve this problem using a "top-down"
     * recursion solution.
     * <p>
     * Or you can think the problem in this way: for a node in a tree, if you know the answer of its children, can you
     * calculate the answer of the node? If the answer is yes, solving the problem recursively from bottom up might be a
     * good way.
     * <p>
     * In the following sections, we provide several classic problems for you to help you understand tree structure and
     * recursion better.
     */

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);

        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(new MaximumDepthofBinaryTree().maximum_depth(root));
        System.out.println(new MaximumDepthofBinaryTree().maxDepth(root));
    }
}
