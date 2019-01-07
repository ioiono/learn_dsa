package fmt.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;


public class PopulatingNextRightPointersinEachNode {
    // this works for both I & II
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        root.next = null;
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            TreeLinkNode pre = q.peek();
            for (int i = 0; i < size; i++) {
                TreeLinkNode cur = q.poll();
                pre.next = cur;
                pre = cur;
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            pre.next = null;
        }


    }
}
