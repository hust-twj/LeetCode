package list;

import tool.ListNode;

/**
 * @author hust_twj
 * @date 2019/8/16 | 2021/05/12
 */
public class HasCycle {

    public static void main(String[] args) {
        ListNode listNode = ListNode.generateListNode();
        System.out.println(hasCycle(listNode));
    }

    public static boolean hasCycle(ListNode head) {
        //快慢指针，快的每次移动2个节点，慢的每次移动1个节点
        ListNode slow = head;
        ListNode fast = head;
        //循环条件，不为空
        while (slow != null &&  fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

}
