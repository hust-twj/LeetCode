package list;

import tool.ListNode;

/**
 * Description ：删除排序链表中的重复元素
 * Created by Wenjing.Tang on 2019-09-03.
 * <p>
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class DeleteDuplicates {

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
