package fmt.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return 0;
        int cnt = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            cnt++;
            int levelNum = queue.size(); // ps
            for (int i = 0; i < levelNum; i++) {
                TreeNode top = queue.peek();
                if (top.left == null && top.right == null) {
                    return cnt;
                }
                if (top.left != null) queue.offer(top.left);
                if (top.right != null) queue.offer(top.right);
                queue.poll();
            }
        }
        return cnt;
    }

    private int min = Integer.MAX_VALUE;

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, 0);
        return min;
    }

    public void helper(TreeNode node, int ht) {
        if (node == null) return;

        if (node.left == null && node.right == null) min = Math.min(min, ht + 1);

        if (node.left != null) helper(node.left, ht + 1);
        if (node.right != null) helper(node.right, ht + 1);
    }

    public static void main(String[] args) {
        Codec cc = new Codec();
        TreeNode rt = cc.deserialize("3,9,null,null,20,15,null,null,7,null,null");

        MinimumDepthofBinaryTree m = new MinimumDepthofBinaryTree();
        System.out.println(m.minDepth(rt));
        System.out.println(m.minDepth2(rt));
    }
}
