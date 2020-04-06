package list;

import tool.ListNode;

import java.util.Stack;

/**
 * Description ：链表两数相加2（高位在前）
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 * <p>
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 * Created by Wenjing.Tang on 2020/4/6.
 */
public class AddTwoNumber_445 {

    public static void main(String[] args) {

        ListNode l0 = new ListNode(7);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l0.next = l1;
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;


    }

    /**
     * 反转：
     * https://leetcode-cn.com/problems/add-two-numbers-ii/solution/java-yi-dong-yi-jie-xiao-lu-gao-by-spirit-9-50/
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        //均不为null
        ListNode reverse1 = reverseList(l1);
        ListNode reverse2 = reverseList(l2);
        while (reverse1 != null || reverse2 != null) {

        }

        return null;
    }

    private static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    /**
     * 栈：
     * https://leetcode-cn.com/problems/add-two-numbers-ii/solution/shi-yong-liang-ge-zhan-by-tui-qiao/
     */
    private static ListNode addTwo(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();
        ListNode node1 = l1;
        while (node1 != null) {
            stack1.push(node1.val);
            node1 = node1.next;
        }
        ListNode node2 = l2;
        while (node2 != null) {
            stack2.push(node2.val);
            node2 = node2.next;
        }
        ListNode head = null;
        int flag = 0;
        // [5] , [5] --> [1->0]
        while (!stack1.isEmpty() || !stack2.isEmpty() || flag != 0) {
            int value = 0;
            if (!stack1.isEmpty())
                value += stack1.pop();
            if (!stack2.isEmpty())
                value += stack2.pop();
            value += flag;
            ListNode node = new ListNode(value % 10);
            flag = value / 10;
            node.next = head;
            head = node;
        }
        return head;
    }


}
