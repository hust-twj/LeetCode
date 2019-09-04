package list;

import tool.ListNode;
import tool.ListNodeUtils;

/**
 * Description ：链表的中间结点
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * Created by Wenjing.Tang on 2019-09-04.
 */
public class MiddleNode {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5,6};
        ListNode original = ListNodeUtils.convertArray2ListNode(array);
        ListNodeUtils.printListNode(original);

        System.out.println("");
        ListNode result = middleNode2(original);
        ListNodeUtils.printListNode(result);

    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if (head.next == null) {
            return head;
        }else if (head.next.next == null) {
            return head.next;
        }
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //偶数的情况
        if (fast.next != null) {
            slow = slow.next;
        }
        return slow;

    }

    /**
     * 优化版
     * @param head
     * @return
     */
    public static ListNode middleNode2(ListNode head) {
        ListNode slow = head, fast = head;
        //关键：这个条件
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}
