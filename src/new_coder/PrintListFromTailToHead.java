package new_coder;

import tool.ListNode;

import java.util.*;

/**
 * 从尾到头打印链表
 * https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Description ：
 * Created by Wenjing.Tang on 2019-10-17.
 * <p>
 * 输入一个链表，按链表从尾到头的顺序返回一个 ArrayList。
 */
public class PrintListFromTailToHead {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ArrayList<Integer> result = printListFromTailToHead(listNode1);

        for (Integer list : result) {
            System.out.println(list);
        }

    }

    /**
     * 方法1：转为ArrayList，然后ArrayList反转
     *
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();

        while (listNode != null) {
            result.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(result);
        return result;
    }

    /**
     * 方法2：先链表反转，再添加到ArrayList
     *
     * @param listNode
     * @return
     */
    // TODO: 2019-10-17  
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        ListNode reverseListNode = reverseList(listNode);

        while (reverseListNode != null) {
            result.add(reverseListNode.val);
            reverseListNode = reverseListNode.next;
        }
        return result;
    }

    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //哨兵节点
        ListNode dummy = new ListNode(-1);

        //注意这句：dummy赋值给current，操作current，current 和 dummy 会同时变化
        ListNode current = dummy;
        Deque<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            Integer integer = stack.pop();
            current.next = new ListNode(integer);
            current = current.next;
        }
        //将第一个节点创建出来，返回时在返回 next。非常巧妙的技巧
        return dummy.next;
    }

    /**
     * 方法3：反转 --> 利用 "栈" 的性质
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        Deque<Integer> stack = new LinkedList<>();

        ArrayList<Integer> result = new ArrayList<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            Integer integer = stack.pop();
            result.add(integer);
        }
        return result;
    }

}
