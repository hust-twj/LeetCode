package list;

import tool.ListNode;

/**
 * Description ：单向链表反转
 * Created by Wenjing.Tang on 2019-08-13.
 * 思路：使用两个指针
 * 步骤：
 * 1 -> 2 -> 3 -> 4
 * 2 -> 1 -> 3 -> 4
 * 3 -> 2 -> 1 -> 4
 * 4 -> 3 -> 2 -> 1
 */
public class ReverseList {

    public static void main(String[] args) {

        ListNode listNode = ListNode.generateListNode();

        ListNode.printListNode(listNode);

        ListNode reversedListNode = reverseList(listNode);
        ListNode.printListNode(reversedListNode);
    }

    /**
     * 1、迭代（非递归）
     * https://blog.csdn.net/FX677588/article/details/72357389
     * https://blog.csdn.net/biezhihua/article/details/79922332
     * https://blog.csdn.net/feliciafay/article/details/6841115
     */
    private static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode nextNode = head.next;  //暂存head下一个地址，防止变化指针指向后找不到后续的数
            head.next  = newHead;//head.next指向前一个空间
            newHead = head;//新链表的头移动到head，扩长一步链表
            head = nextNode; //head指向原始链表head指向的下一个空间
        }
        return newHead;
    }

}
