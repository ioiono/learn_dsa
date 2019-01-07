package fmt.BinaryTree;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return cons(nums, 0, nums.length);
    }

    private TreeNode cons(int[] nums, int l, int r) {
        if (l >= r) return null;
        int idx = getMaxIndex(nums, l, r);
        TreeNode root = new TreeNode(nums[idx]);

        root.left = cons(nums, l, idx);
        root.right = cons(nums, idx + 1, r);

        return root;
    }

    private int getMaxIndex(int[] nums, int l, int r) {
        int maxIdx = l;
        for (int i = l; i < r; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }

        return maxIdx;
    }
}
