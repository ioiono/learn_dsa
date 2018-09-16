package fmt.LinkedList;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the
 * original list.
 * <p>
 * Example 1: Input: 1->2->3->3->4->4->5 Output: 1->2->5
 * <p>
 * Example 2: Input: 1->1->1->2->3 Output: 2->3
 */
public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode node = dummyHead;

        while (node.next != null && node.next.next != null) {
            if (node.next.val == node.next.next.val) {
                int duplicatedVal = node.next.val;
                while (node.next != null && node.next.val == duplicatedVal) {
                    node.next = node.next.next;
                }
            } else {
                node = node.next;
            }
        }

        return dummyHead.next;
    }
}
