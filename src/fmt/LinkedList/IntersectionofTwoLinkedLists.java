package fmt.LinkedList;

public class IntersectionofTwoLinkedLists {

    int getLength(ListNode root) {
        int len = 0;
        while (root != null) {
            root = root.next;
            len++;
        }
        return len;

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        if (lenA > lenB) {
            while (lenA > lenB) {
                headA = headA.next;
                lenA--;
            }
        } else {
            while (lenB > lenA) {
                headB = headB.next;
                lenB--;
            }
        }

        while (headA != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(0);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(2);
        headA.next.next.next = new ListNode(3);

        ListNode headB = new ListNode(233);
        headB.next = headA.next;
        IntersectionofTwoLinkedLists ins = new IntersectionofTwoLinkedLists();
        System.out.println(ins.getIntersectionNode(headA, headB).val);

    }
}
