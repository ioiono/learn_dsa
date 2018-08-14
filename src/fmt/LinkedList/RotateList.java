package fmt.LinkedList;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode index = head;
        int len = 1;
        while (index.next != null) {
            index = index.next;
            len++;
        }
        index.next = head;
        for (int i = 1; i < len - k % len; i++) {
            head = head.next;
        }

        ListNode res = head.next;
        head.next = null;
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);

        RotateList rl = new RotateList();
        LLUtils.printLL(rl.rotateRight(head, 2));
    }
}
