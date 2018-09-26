package fmt.BinaryTree;

import java.util.HashMap;

public class PathSumIII {
    // brute force
    public int pathSumBF(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0) + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }
    //
    //    public int pathSum(TreeNode root, int sum) {
    //        if (root == null) return 0;
    //        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    //    }
    //
    //    public int findPath(TreeNode root, int sum) {
    //        int res = 0;
    //        if (root == null) return 0;
    //        if (sum == root.val) res++;
    //        res += findPath(root.left, sum - root.val);
    //        res += findPath(root.right, sum - root.val);
    //        return res;
    //    }


    /**
     * Each time find all the path start from current node Then move start node to the child and repeat. Time Complexity
     * should be O(N^2) for the worst case and O(NlogN) for balanced binary Tree.
     */
    private int res = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        findPath(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return res;
    }

    public void findPath(TreeNode root, int sum) {
        if (root == null) return;
        if (sum == root.val) res++;
        findPath(root.left, sum - root.val);
        findPath(root.right, sum - root.val);
    }

    // O(N)
    public int pathSum2(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1); //Default sum = 0 has one count
        return helper(root, 0, sum, preSum);
    }

    //BackTrack one pass
    public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) return 0;

        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0); // See if there is a subarray sum equals to target
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
        // Extend to left and right child
        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1); // Remove the current node so it wont affect other path
        return res;
    }
}
