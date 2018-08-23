package fmt.NaryTree;

import java.util.*;


public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;

    }

    void helper(Node root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        for (Node node : root.children) {
            helper(node, list);
        }
    }

    public List<Integer> preorderIter(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) return list;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.empty()) {
            root = stack.pop();
            list.addFirst(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--)
                stack.add(root.children.get(i));
        }

        return list;
    }

    public static void main(String[] args) {
        List<Node> ch2 = new ArrayList<>(Arrays.asList(new Node(5, new ArrayList<>()), new Node(6, new ArrayList<>())));
        List<Node> ch1 = new ArrayList<>(Arrays.asList(new Node(3, ch2), new Node(2, new ArrayList<>()), new Node(4, new ArrayList<>())));
        Node root = new Node(1, ch1);

        System.out.println(new NaryTreePreorderTraversal().preorder(root));

    }
}
