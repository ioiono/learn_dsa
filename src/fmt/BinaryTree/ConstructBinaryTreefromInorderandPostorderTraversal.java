package fmt.BinaryTree;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * <p>
 * Note: You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * inorder = [9,3,15,20,7] postorder = [9,15,7,20,3] Return the following binary tree:
 * <p>
 * 3 / \ 9  20 /  \ 15   7
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length || inorder.length == 0)
            return null;
        int length = inorder.length;
        TreeNode root = buildTree(inorder, 0, length - 1, postorder, 0, length - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        if (iStart > iEnd || pStart > pEnd)
            return null;

        TreeNode root = new TreeNode(postorder[pEnd]);
        int index = 0;
        while (inorder[iStart + index] != root.val)
            index++;
        root.left = buildTree(inorder, iStart, iStart + index - 1, postorder, pStart, pStart + index - 1);
        root.right = buildTree(inorder, iStart + index + 1, iEnd, postorder, pStart + index, pEnd - 1);

        return root;

    }

    public static void main(String[] args) {

    }
}
