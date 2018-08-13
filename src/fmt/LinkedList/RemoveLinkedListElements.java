package fmt.LinkedList;

public class RemoveLinkedListElements {
    public ListNode removeElementsRec(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElementsRec(head.next, val);
        return head.val == val ? head.next : head;
    }
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = head, pre = dummy;

        while (curr != null) {
            if (curr.val == val) {
                pre.next = curr.next;
            } else {
                pre = pre.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(0);
//        head.next = new ListNode(0);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next = new ListNode(2);
        LLUtils.printLL(head);
        LLUtils.printLL(new RemoveLinkedListElements().removeElements(head, 0));

    }
}
