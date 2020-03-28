package sword_to_offer;

import tool.ListNode;

/**
 * Description ：剑指offer 第 22 题：删除倒数第K个节点
 * Created by Wenjing.Tang on 2020/3/28.
 */
public class Sword2Offer_22 {

    public static void main(String[] args) {

        ListNode listNode = ListNode.generateListNode();
        ListNode.printListNode(listNode);

        ListNode.printListNode(removeNthFromEnd(listNode, 7));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return null;
        }
        //设置哑结点，便于操作链表
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            if (first.next == null) {
                return null;
            }
            first = first.next;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static ListNode deleteKthNodeFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
//        ListNode dummyNode = new ListNode(0);
//        dummyNode.next = head;
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
