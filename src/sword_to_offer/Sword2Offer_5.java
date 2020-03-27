package sword_to_offer;

import tool.ListNode;

import java.util.Stack;

/**
 * Description ：剑指offer 第 5 题：从尾到头打印链表
 * Created by Wenjing.Tang on 2020/3/27.
 */
public class Sword2Offer_5 {

    public static void main(String[] args) {

        ListNode listNode = ListNode.generateListNode();

        ListNode.printListNode(listNode);

        printFromEnd2Head(listNode);

    }

    private static void printFromEnd2Head(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        if (head == null) {
            System.out.println("null");
            return;
        }
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
