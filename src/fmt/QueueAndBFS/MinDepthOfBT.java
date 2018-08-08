package fmt.QueueAndBFS;


import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class MinDepthOfBT {
    boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int depth = 0; // from root
        while (!que.isEmpty()) {
            depth++;
            int size = que.size();

            for (int i = 0; i < size; i++) {

                TreeNode cur = que.poll();
                if (isLeaf(cur)) {
                    return depth;
                } else {
                    if (cur.left != null) {
                        que.offer(cur.left);
                    }
                    if (cur.right != null) {
                        que.offer(cur.right);
                    }
                }
            }

        }
        return depth;
    }

    private int minDepthRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.min(minDepthRec(root.left), minDepthRec(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new MinDepthOfBT().minDepth(root));
        System.out.println(new MinDepthOfBT().minDepthRec(root));

        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(3);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(4);
        System.out.println(new MinDepthOfBT().minDepth(root1));
        System.out.println(new MinDepthOfBT().minDepthRec(root1));
    }
}
