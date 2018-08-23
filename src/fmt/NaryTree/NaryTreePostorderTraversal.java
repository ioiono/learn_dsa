package fmt.NaryTree;

import java.util.*;

public class NaryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        for (Node node : root.children) {
            helper(node, list);
        }
        list.add(root.val);
    }

    public List<Integer> postorderIter(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            stack.addAll(root.children);
        }
        Collections.reverse(list);
        return list;
    }

    public List<Integer> postorderII(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) return list;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.empty()) {
            root = stack.pop();
            list.addFirst(root.val);
            for (int i = 0; i <= root.children.size() - 1; i++)
                stack.add(root.children.get(i));

        }

        return list;
    }
}
