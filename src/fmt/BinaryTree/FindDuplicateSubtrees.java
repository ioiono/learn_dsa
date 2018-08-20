package fmt.BinaryTree;

import java.util.*;

public class FindDuplicateSubtrees {

    Map<Long, int[]> counts = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtreesII(TreeNode root) {
        getId(root);
        return ans;
    }

    private int getId(TreeNode root) {
        if (root == null) return 0;
        long key = ((long) root.val) << 32 | getId(root.left) << 16 | getId(root.right);
        int[] id_count = counts.get(key);
        if (id_count == null) {
            id_count = new int[]{counts.size() + 1, 1};
            counts.put(key, id_count);
        } else if (++id_count[1] == 2) {
            ans.add(root);
        }
        return id_count[0];
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        postorder(root, new HashMap<>(), res);
        return res;
    }

    public String postorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
        if (cur == null) return "#";
        String serial = cur.val + "," + postorder(cur.left, map, res) + "," + postorder(cur.right, map, res);
        if (map.getOrDefault(serial, 0) == 1) res.add(cur);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }
//
//
//    Map<String, Integer> count;
//    List<TreeNode> ans;
//
//    public List<TreeNode> findDuplicateSubtreesIII(TreeNode root) {
//        count = new HashMap();
//        ans = new ArrayList();
//        collect(root);
//        return ans;
//    }
//
//    public String collect(TreeNode node) {
//        if (node == null) return "#";
//        String serial = node.val + "," + collect(node.left) + "," + collect(node.right);
//        count.put(serial, count.getOrDefault(serial, 0) + 1);
//        if (count.get(serial) == 2)
//            ans.add(node);
//        return serial;
//    }
}
