package fmt.LinkedList;

import java.util.HashSet;
import java.util.Set;


public class LinkedListCycle {
    /**
     * Complexity analysis
     * <p>
     * Time complexity : O(n). We visit each of the nn elements in the list at most once. Adding a node to the hash
     * table costs only O(1) time.
     * <p>
     * Space complexity: O(n). The space depends on the number of elements added to the hash table, which contains at
     * most nn elements.
     *
     * @param head
     * @return
     */
    public boolean hasCycleII(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    // O(N), O(1)
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (slow != fast && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow == fast;
    }

    public boolean hasCycleIII(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next = head;

        LinkedListCycle cycle = new LinkedListCycle();


        System.out.println(cycle.hasCycle(head));
        System.out.println(cycle.hasCycleII(head));
        System.out.println(cycle.hasCycleIII(head));
    }
}
