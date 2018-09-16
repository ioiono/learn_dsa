package fmt.BinaryTree;

import java.util.*;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level
 * by level from leaf to root).
 * <p>
 * For example: Given binary tree [3,9,20,null,null,15,7], 3 / \ 9  20 /  \ 15   7 return its bottom-up level order
 * traversal as: [ [15,7], [9,20], [3] ]
 */
public class BinaryTreeLevelOrderTraversalII {

    /**
     * @param root
     *
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<>();

        if (root == null) return wrapList;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size(); // ps
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        Collections.reverse(wrapList);
        return wrapList;
    }


    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        travel(res, 0, root);
        Collections.reverse(res);
        return res;
    }

    public void travel(List<List<Integer>> res, int level, TreeNode cur) {
        if (cur == null) return;
        if (level >= res.size()) {
            res.add(new ArrayList<>());
        }

        List<Integer> collection = res.get(level);

        collection.add(cur.val);
        travel(res, level + 1, cur.left);
        travel(res, level + 1, cur.right);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        BinaryTreeLevelOrderTraversalII levelII = new BinaryTreeLevelOrderTraversalII();

        System.out.println(levelII.levelOrderBottom(root));
        System.out.println(levelII.levelOrderBottom2(root));


    }
}
