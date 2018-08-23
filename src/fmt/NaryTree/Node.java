package fmt.NaryTree;

import java.util.List;

public class Node {
    // Definition for a Node.
    public int val;
    public List<fmt.NaryTree.Node> children;

    public Node() {
    }

    public Node(int _val, List<fmt.NaryTree.Node> _children) {
        val = _val;
        children = _children;
    }
}

