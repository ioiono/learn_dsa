package fmt.LinkedList;

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode left = head;
        ListNode right = head;
        while (n-- > 0) {
            right = right.next;
        }
        // 特殊处理如果长度跟n相等。。。
        if (right == null) {
            return head.next;
        }
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);

        RemoveNthNodeFromEndofList re = new RemoveNthNodeFromEndofList();

        LLUtils.printLL(head);
        System.out.println("===========");
        LLUtils.printLL(re.removeNthFromEnd(head, 1));
    }
}
