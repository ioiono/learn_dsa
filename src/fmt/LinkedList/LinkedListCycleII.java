package fmt.LinkedList;


public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return null;

        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow != fast) {
            return null; // no cycle
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next = head;

        LinkedListCycleII cycle = new LinkedListCycleII();

        System.out.println(cycle.detectCycle(head).val);
    }
}
