package fmt.NaryTree;

import java.util.*;

public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrderBFS(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                Node cur = queue.poll();
                for (Node node : cur.children) {
                    queue.offer(node);
                }
                list.add(cur.val);
            }
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> levelOrderDFS(Node root) {
        return levelOrder(root, 0, new ArrayList<>());
    }

    private List<List<Integer>> levelOrder(Node node, int level, List<List<Integer>> order) {
        if (node == null) {
            return order;
        }
        List<Integer> list = order.size() > level ? order.get(level) : new ArrayList<>();
        list.add(node.val);
        if (order.size() <= level) {
            order.add(list);
        }
        for (Node n : node.children) {
            levelOrder(n, level + 1, order);
        }
        return order;
    }

    private List<List<Integer>> levelOrder2(Node node, int level, List<List<Integer>> order) {
        if (node == null) {
            return order;
        }
        if (order.size() <= level) {
            order.add(new ArrayList<>());
        }
        order.get(level).add(node.val);

        for (Node n : node.children) {
            levelOrder(n, level + 1, order);
        }
        return order;
    }

    public static void main(String[] args) {
        List<Node> ch2 = new ArrayList<>(Arrays.asList(new Node(5, new ArrayList<>()), new Node(6, new ArrayList<>())));
        List<Node> ch1 = new ArrayList<>(Arrays.asList(new Node(3, ch2), new Node(2, new ArrayList<>()), new Node(4, new ArrayList<>())));
        Node root = new Node(1, ch1);
        NaryTreeLevelOrderTraversal level = new NaryTreeLevelOrderTraversal();
        System.out.println(level.levelOrderBFS(root));
        System.out.println(level.levelOrderDFS(root));
    }
}
