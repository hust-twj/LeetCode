package list;

import tool.ListNode;

/**
 * Description ：单向链表反转
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * Created by Wenjing.Tang on 2019-08-13.
 * 思路：使用两个指针
 * 步骤：
 * 1 -> 2 -> 3 -> 4
 * 2 -> 1 -> 3 -> 4
 * 3 -> 2 -> 1 -> 4
 * 4 -> 3 -> 2 -> 1
 */
public class ReverseList_206 {

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
     * https://www.jianshu.com/p/bd6a64d36916
     * https://blog.csdn.net/xyh269/article/details/70238501  图解
     */
    private static ListNode reverseList(ListNode head) {
        //pre 相当于 哑结点
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;  //暂存头结点head下一个节点，防止变化指针指向后找不到后续的数 导致指针丢失
            current.next  = pre;//current.next指向"上一个节点"，这一步实现了反转
            pre = current;//pre后移
            current = next; //current后移，准备开启新的循环
        }
        return pre;
    }

    /**
     * 2、递归
     * https://stackoverflow.com/questions/354875/reversing-a-linked-list-in-java-recursively
     * https://blog.csdn.net/FX677588/article/details/72357389
     */
    // TODO: 2019-08-14  
    private static ListNode reverseList2(ListNode head) {
        //递归终止条件：当head为空或者只有一个节点时，返回
        if (head == null || head.next == null) {
            return head;
        }
        //递归调用，直到链尾
        ListNode reverseRest = reverseList2(head.next);
        //翻转链表指向
        head.next.next = head;
        head.next = null;
        return reverseRest;
    }

    /**
     * 3、栈
     */
    private static ListNode reverseList3(ListNode head) {
        return null;
    }
}
