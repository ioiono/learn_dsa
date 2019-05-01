package fmt.BinaryTree;

import java.util.*;

public class MostFrequentSubtreeSum {
    private Map<Integer, Integer> sumToCount = new HashMap<>();

    private int maxCount = 0;

    public int[] findFrequentTreeSum(TreeNode root) {

        getSubsum(root);

        List<Integer> res = new ArrayList<>();
        for (int key : sumToCount.keySet()) {
            if (sumToCount.get(key) == maxCount) {
                res.add(key);
            }
        }

        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    private int getSubsum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = getSubsum(root.left);
        int r = getSubsum(root.right);
        int sum = root.val + l + r;
        int count = sumToCount.getOrDefault(sum, 0) + 1;
        sumToCount.put(sum, count);

        maxCount = Math.max(maxCount, count);
        return sum;
    }

    public static void main(String[] args) {
        Codec cc = new Codec();
        TreeNode rt = cc.deserialize("10,2,null,null,4,null,null");
        MostFrequentSubtreeSum m = new MostFrequentSubtreeSum();
        System.out.println(Arrays.toString(m.findFrequentTreeSum(rt)));
    }
}
