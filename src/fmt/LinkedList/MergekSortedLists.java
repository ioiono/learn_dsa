package fmt.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergekSortedLists {
    // NlgN
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> nums = new ArrayList<>();
        for (ListNode list : lists) {
            ListNode head = list;
            while (head != null) {
                nums.add(head.val);
                head = head.next;
            }
        }
        Collections.sort(nums);
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        for (int num : nums) {
            head.next = new ListNode(num);
            head = head.next;
        }
        return dummy.next;
    }

    // NlgK
    public ListNode mergeKLists(ListNode[] lists) {

    }

    public static void main(String[] args) {

    }

}
