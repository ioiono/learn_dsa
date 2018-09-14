package fmt.LinkedList;

public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        // find the k+1 node
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // if k+1 node exists
        if (count == k) {
            // reverse list with k+1 node as head
            curr = reverseKGroup(curr, k);
            // head - head-pointer to direct part, (like curr node in Reverse Linked List)
            // curr - head-pointer to reversed part (like pre node in Reverse Linked List)
            while (count-- > 0) {      // reverse current k-group
                ListNode temp = head.next;  // temp - next head in direct part
                head.next = curr; // pre appending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = temp; // move "direct" head to the next node in direct part
            }
            head = curr; // make head point to curr (important)
        }
        return head;
    }
}
