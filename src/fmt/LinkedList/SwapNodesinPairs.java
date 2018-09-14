package fmt.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        for (int i = 0; i + 1 < list.size(); i += 2) {
            int t = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, t);
        }
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;
        for (int val : list) {
            tmp.next = new ListNode(val);
            tmp = tmp.next;
        }
        return dummy.next;


    }

    public ListNode swapPairsRec(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        } else {
            // head.next exists
            ListNode second = head.next;
            ListNode nextTwo = swapPairs(second.next);
            second.next = head;
            head.next = nextTwo;
            return second;
        }
    }


    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = dummy;
        ListNode l2 = head;
        while (l2 != null && l2.next != null) {
            ListNode nextStart = l2.next.next;
            l1.next = l2.next;
            l2.next.next = l2;
            l2.next = nextStart;
            l1 = l2;
            l2 = l2.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);

        SwapNodesinPairs snp = new SwapNodesinPairs();

        LLUtils.printLL(snp.swapPairs(head));
//        LLUtils.printLL(snp.swapPairsRec(head));
    }
}
