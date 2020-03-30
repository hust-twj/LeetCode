package sword_to_offer;

import tool.ListNode;

/**
 * Description ：剑指offer 第 23 题：链表反转
 * Created by Wenjing.Tang on 2020/3/29.
 */
public class Sword2Offer_23 {

    public static ListNode reverseListNode(ListNode head) {
        if (head == null) {
            return null;
        }
        //需要三个指针，前、中、后
        ListNode current = head;
        ListNode pre = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
}
