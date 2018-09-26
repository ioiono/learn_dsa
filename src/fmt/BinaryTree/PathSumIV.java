package fmt.BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class PathSumIV {
    /**
     * Time Complexity: O(N) where NN is the length of nums. We construct the graph and traverse it in this time.
     * <p>
     * Space Complexity: O(N), the size of the implicit call stack in our depth-first search.
     */
    private int ans = 0;

    public int pathSum(int[] nums) {
        TreeNode root = new TreeNode(nums[0] % 10);
        for (int num : nums) {
            if (num == nums[0]) continue;
            int depth = num / 100, pos = num / 10 % 10, val = num % 10;
            pos--;
            TreeNode cur = root;
            for (int d = depth - 2; d >= 0; --d) {
                if (pos < 1 << d) {
                    if (cur.left == null) cur.left = new TreeNode(val);
                    cur = cur.left;
                } else {
                    if (cur.right == null) cur.right = new TreeNode(val);
                    cur = cur.right;
                }
                pos %= 1 << d;
            }
        }

        dfs(root, 0);
        return ans;
    }

    public void dfs(TreeNode node, int sum) {
        if (node == null) return;
        sum += node.val;
        if (node.left == null && node.right == null) {
            ans += sum;
        } else {
            dfs(node.left, sum);
            dfs(node.right, sum);
        }
    }

    int res = 0;
    Map<Integer, Integer> values;

    public int pathSum2(int[] nums) {
        values = new HashMap<>();
        for (int num : nums)
            values.put(num / 10, num % 10);

        dfs(nums[0] / 10, 0);
        return res;
    }

    public void dfs(int node, int sum) {
        if (!values.containsKey(node)) return;
        sum += values.get(node);

        int depth = node / 10, pos = node % 10;
        int left = (depth + 1) * 10 + 2 * pos - 1;
        int right = left + 1;

        if (!values.containsKey(left) && !values.containsKey(right)) {
            res += sum;
        } else {
            dfs(left, sum);
            dfs(right, sum);
        }
    }
}
