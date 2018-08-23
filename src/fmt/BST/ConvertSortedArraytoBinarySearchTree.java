package fmt.BST;

public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = (hi - lo) / 2 + lo;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, lo, mid - 1);
        root.right = helper(nums, mid + 1, hi);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-9, -3, 0, 9, 10};
        System.out.println(TreeUtils.inorderTraversal(new ConvertSortedArraytoBinarySearchTree().sortedArrayToBST(nums)));
    }
}
