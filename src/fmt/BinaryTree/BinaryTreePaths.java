package fmt.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        if (root == null) return answer;
        searchBT(root, "", answer);
        return answer;
    }

    private void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) answer.add(path + root.val);
        if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
        if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
    }

    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> path = new ArrayList<>();

        preorder(root, res, path);
        return res;
    }

    private void preorder(TreeNode root, List<String> res, List<Integer> path) {
        if (root == null) return;
        path.add(root.val);

        if (root.left == null && root.right == null) {

            String str = "" + path.get(0);
            for (int i = 1; i < path.size(); i++) {
                str += "->" + path.get(i);
            }

            res.add(str);
        }

        preorder(root.left, res, path);
        preorder(root.right, res, path);
        path.remove(path.size() - 1);
    }
}
