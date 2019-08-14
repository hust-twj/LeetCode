package list;

import tool.ListNode;


/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 19. 删除链表的倒数第N个节点
 * 解题思路：双指针
 * https://cxyxiaowu.com/articles/2019/05/02/1556786655969.html
 * Created by Wenjing.Tang on 2019-08-13.
 */
public class RemoveNthFromEnd_19 {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode.printListNode(head);

        ListNode removedListNode = removeNthFromEnd2(head, 2);
        ListNode.printListNode(removedListNode);

    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        //起始指针
        ListNode start = head;
        //终止指针
        ListNode end = head;

        //终止指针先走n步，当走到最后一个节点时，起始指针的下一个节点即为所要删除的节点
        //n+1 两指针之间需要隔n个位置
        for (int i = 0; i < n + 1; i++) {
            //需要注意，如果end==null，说明n为链表长度，即要删除第一个节点
            if (end == null) {
                return head.next;
            }
            end = end.next;
        }

        //双指针同步走
        while (end != null) {
            end = end.next;
            start = start.next;
        }
        //删除起始指针的后一个节点位置
        start.next = start.next.next;

        return head;
    }

}
