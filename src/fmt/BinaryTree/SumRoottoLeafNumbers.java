package fmt.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class SumRoottoLeafNumbers {
    private int res = 0;

    public int sumNumbers(TreeNode root) {
        List<Integer> nums = new ArrayList<>();

        preorder(root, nums);


        return res;
    }

    private void preorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        nums.add(root.val);
        if (root.left == null && root.right == null) {
            int sum = 0;

            for (Integer num : nums) {
                sum = sum * 10 + num;
            }

            res += sum;
        }
        preorder(root.left, nums);
        preorder(root.right, nums);

        nums.remove(nums.size() - 1);
    }


    // O(1) Space
    private int sumN = 0;

    public int sumNumbers2(TreeNode root) {
        dfsSumNumbers(root, 0);
        return sumN;
    }

    private void dfsSumNumbers(TreeNode root, int currentSum) {
        if (root == null) return;
        currentSum = currentSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            sumN += currentSum;
            return;
        }

        dfsSumNumbers(root.left, currentSum);
        dfsSumNumbers(root.right, currentSum);

    }
}
