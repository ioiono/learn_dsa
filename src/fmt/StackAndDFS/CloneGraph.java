package fmt.StackAndDFS;

import java.util.*;

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
}

public class CloneGraph {

    private HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {
        return helper(node);
    }

    private UndirectedGraphNode helper(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        UndirectedGraphNode dup = new UndirectedGraphNode(node.label);
        map.put(node, dup);

        for (UndirectedGraphNode neighbor : node.neighbors) {
            UndirectedGraphNode clone = helper(neighbor);
            dup.neighbors.add(clone);
        }
        return dup;
    }

    public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node) {
        if (node == null) return null;

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label); //new node for return
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>(); //store visited nodes

        map.put(newNode.label, newNode); //add first node to HashMap

        Queue<UndirectedGraphNode> queue = new LinkedList<>(); //to store **original** nodes need to be visited
        queue.add(node); //add first **original** node to queue

        while (!queue.isEmpty()) { //if more nodes need to be visited
            UndirectedGraphNode n = queue.poll(); //search first node in the queue
            for (UndirectedGraphNode neighbor : n.neighbors) {
                if (!map.containsKey(neighbor.label)) { //add to map and queue if this node hasn't been searched before
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }
                map.get(n.label).neighbors.add(map.get(neighbor.label)); //add neighbor to new created nodes
            }
        }

        return newNode;
    }


    public static void main(String[] args) {
        UndirectedGraphNode root = new UndirectedGraphNode(0);
        root.neighbors = new ArrayList<>();
        root.neighbors.add(new UndirectedGraphNode(1));
        System.out.println(new CloneGraph().cloneGraphDFS(root));
        System.out.println(new CloneGraph().cloneGraphBFS(root));
    }


}
