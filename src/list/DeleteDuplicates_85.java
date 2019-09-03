package list;

import tool.ListNode;

/**
 * Description ：删除排序链表中的重复元素
 * Created by Wenjing.Tang on 2019-09-03.
 * <p>
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 注意：
 * 1、题目已经排序
 * 2、用current指针循环操作链表：如果有值相等，就将当前节点的next指针 指向 下一个节点的 next 指针；否则当前节点后移
 *
 *
 */
public class DeleteDuplicates_85 {

    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {

        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;

    }

}
