package list;

import tool.ListNode;
import tool.ListNodeUtils;

/**
 * Description ：移除链表元素
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * Created by Wenjing.Tang on 2019-09-04.
 */
public class RemoveElements_203 {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 6, 3, 4, 5, 6};
        ListNode original = ListNodeUtils.convertArray2ListNode(array);
        ListNodeUtils.printListNode(original);

        System.out.println("");
        ListNode result = removeElements(original, 6);
        ListNodeUtils.printListNode(result);


    }

    public static ListNode removeElements(ListNode head, int val) {
        //头结点的值相等
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode current = head;
        //对于删除节点，需要先找到该节点的前一个节点，然后进行删除
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }

        }
        return head;
    }

}
