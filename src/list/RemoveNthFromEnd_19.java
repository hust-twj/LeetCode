package list;

import tool.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 19. 删除链表的倒数第N个节点
 * 解题思路：双指针
 * https://cxyxiaowu.com/articles/2019/05/02/1556786655969.html
 * Created by Wenjing.Tang on 2019-08-13.
 */
public class RemoveNthFromEnd_19 {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

       // ListNode.printListNode(head);
        System.out.println(head.toString());

        ListNode removedListNode = removeNthFromEnd(head, 2);
        ListNode.printListNode(removedListNode);

        ListNode.printListNode(head);

//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//         ListNode.printListNode(convertList2Node(list));
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode start;
        ListNode end;

        return head;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode leader = head;
        ListNode follower = head;
        //领导先行n步
        for (int i = 0; i < n + 1; i++) {
            if (leader == null) {
                return head.next;
            }
            leader = leader.next;
        }
        //同步前进直到领导到末尾
        while (leader != null) {
            leader = leader.next;
            follower = follower.next;
        }
        //删除追随者处的节点
        follower.next = follower.next.next;
        return head;
    }

    public static List<Integer> convertNode2List(ListNode listNode) {
        List<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        list.add(listNode.val);
        while (listNode.next != null) {
            list.add(listNode.next.val);
        }
        return list;
    }

    public static ListNode convertList2Node(List<Integer> list) {
        ListNode listNode = new ListNode(-1);
        if (list == null || list.size() == 0) {
            return listNode;
        }
//        listNode = new ListNode(list.get(0));
//        if (list.size() > 1) {
//            for (int i = 0; i < list.size(); i++) {
//                listNode.next.val = list.get(1);
//            }
//        }
        return listNode;
    }

}
