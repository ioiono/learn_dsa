package fmt.LinkedList;

public class ReverseLL {
    public ListNode reverseList(ListNode head) {
        /* recursive solution */
        return reverseListInt(head, null);
    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }


    public ListNode reverseListII(ListNode head) {
        /* iterative solution */
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public ListNode reverseListIII(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode nextNode = head.next;
        ListNode newHead = reverseListIII(nextNode);
        nextNode.next = head;
        head.next = null;
        return newHead;
    }


    /**
     * Approach #2 (Recursive) [Accepted] The recursive version is slightly trickier and the key is to work backwards.
     * Assume that the rest of the list had already been reversed, now how do I reverse the front part? Let's assume the
     * list is: n1 → … → nk-1 → nk → nk+1 → … → nm → Ø
     * <p>
     * Assume from node nk+1 to nm had been reversed and you are at node nk.
     * <p>
     * n1 → … → nk-1 → nk → nk+1 ← … ← nm
     * <p>
     * We want nk+1’s next node to point to nk.
     * <p>
     * So,
     * <p>
     * nk.next.next = nk;
     * <p>
     * Be very careful that n1's next must point to Ø. If you forget about this, your linked list has a cycle in it.
     * This bug could be caught if you test your code with a linked list of size 2.
     *
     * @param head
     * @return
     */
    public ListNode reverseListIIII(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode root = reverseListIIII(head.next);

        head.next.next = head;
        head.next = null;
        return root;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);

        ReverseLL rev = new ReverseLL();
        LLUtils.printLL(head);
        LLUtils.printLL(rev.reverseListIIII(head));

    }
}
