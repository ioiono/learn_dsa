package fmt.LinkedList;

public class LLUtils {
    static void printLL(ListNode head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.println("null]");
    }

}
