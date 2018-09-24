package fmt.BinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeandDeserializeBinaryTree {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        Codec cc = new Codec();
        System.out.println(cc.serialize(root));
        System.out.println(cc.serialize(cc.deserialize("1,2,null,null,3,4,null,null,4,null,null,")));
    }

}

class Codec {

    private void helper0(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null").append(",");
        } else {
            sb.append(root.val).append(",");
            helper0(root.left, sb);
            helper0(root.right, sb);
        }

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper0(root, sb);
        return sb.toString();
    }

    private TreeNode helper1(LinkedList<String> list) {
        if (list.get(0).equals("null")) {
            list.removeFirst();
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(list.peekFirst()));
        list.removeFirst();
        root.left = helper1(list);
        root.right = helper1(list);

        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        LinkedList<String> list = new LinkedList<>(Arrays.asList(data_array));
        return helper1(list);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));