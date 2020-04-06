package list;

import tool.ListNode;
import tool.ListNodeUtils;

/**
 * 2. 两数相加（低位在前，可以直接从头开始加）
 * https://leetcode-cn.com/problems/add-two-numbers/
 * Description ：
 * Created by Wenjing.Tang on 2019-10-29.
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumber_2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;

        ListNode listNode = addTwoNumbers(l1, l4);
    }

    /**
     * 暴力法（long型的会溢出）
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //反转
        ListNode reverse1 = reverseList(l1);
        ListNode reverse2 = reverseList(l2);
        //位数
        int length1 = 0, length2 = 0;
        ListNode p1 = reverse1, p2 = reverse2;

        //获取各个链表的位数
        while (p1 != null) {
            length1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            length2++;
            p2 = p2.next;
        }

        // System.out.println(length1 + "  " + length2);

        //将链表转为整数
        int number1 = 0, number2 = 0, result = 0;
        ListNode q1 = reverse1, q2 = reverse2;
        while (q1 != null) {
            number1 += (int) (q1.val * Math.pow(10, length1 - 1));
            length1--;
            q1 = q1.next;
        }
        while (q2 != null) {
            number2 += (int) (q2.val * Math.pow(10, length2 - 1));
            length2--;
            q2 = q2.next;
        }
        result = number1 + number2;

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (result > 10) {
            int diget = result % 10;
            current.next = new ListNode(diget);
            current = current.next;
//            if (dummy == null) {
//                resultNode = new ListNode(diget);
//            } else {
//                resultNode.next = new ListNode(diget);
//            }
            result /= 10;

            if (result < 10) {
                current.next = new ListNode(result);
                current = current.next;
            }
        }
//        if (result > 0 && resultNode != null) {
//            resultNode.next = new ListNode(result);
//        }

        ListNodeUtils.printListNode(dummy.next);
        //System.out.println(number1 + "  " + number2 + "  " + result);
        return null;
    }

    /**
     * 链表反转
     *
     * @param head
     * @return
     */
    private static ListNode reverseList(ListNode head) {
        //pre 相当于 哑结点
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;  //暂存头结点head下一个节点，防止变化指针指向后找不到后续的数 导致指针丢失
            current.next = pre;//current.next指向"上一个节点"，这一步实现了反转
            pre = current;//pre后移
            current = next; //current后移，准备开启新的循环
        }
        return pre;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        // TODO: 2019-10-29
        return null;

    }
}

