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
     * https://github.com/MisterBooo/LeetCodeAnimation/blob/master/notes/LeetCode%E7%AC%AC206%E5%8F%B7%E9%97%AE%E9%A2%98%EF%BC%9A%E5%8F%8D%E8%BD%AC%E9%93%BE%E8%A1%A8.md
     * https://blog.csdn.net/FX677588/article/details/72357389
     * https://blog.csdn.net/biezhihua/article/details/79922332
     * https://blog.csdn.net/feliciafay/article/details/6841115
     */
    private static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;  //暂存head下一个地址，防止变化指针指向后找不到后续的数
            current.next  = pre;//current.next指向前一个空间
            pre = current;//pre后移
            current = next; //current后移，准备开启新的循环
        }
        return pre;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    // TODO: 2019-08-14  
    private static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reverseRest = null;

        return reverseRest;
    }

}
