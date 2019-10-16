package list;

import tool.ListNode;
import tool.ListNodeUtils;

/**
 * Description ：合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * Created by Wenjing.Tang on 2019-08-14.
 */
public class MergeTwoLists_21 {

    public static void main(String[] args) {
        int[] array = new int[]{1};
        ListNode node1 = ListNodeUtils.convertArray2ListNode(array);
        ListNodeUtils.printListNode(node1);
        System.out.println("");

        int[] array2 = new int[]{1, 3, 4};
        ListNode node2 = ListNodeUtils.convertArray2ListNode(array2);
        ListNodeUtils.printListNode(node2);
        System.out.println("");

        ListNode result = mergeTwoLists(node1, node2);
        ListNodeUtils.printListNode(result);

        System.out.println();
        ListNode test1 = new ListNode(1);
        //test = test.next;
        ListNode test2 = new ListNode(2);
        test1.next = test2;
        //test = test.next;
        //ListNode test3 = new ListNode(3);
        test2.next = new ListNode(3);
        ListNodeUtils.printListNode(test1);

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        //新建哨兵节点，方便操作
        ListNode dummy = new ListNode(-1);
        ListNode curNode = dummy;

        /**
         * 直接赋值，注意容易导致中间链的数据丢失，如：
         * 1 -> 2 -> 4
         * 1 -> 3 -> 4
         * 1 -> 4
         */
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                curNode.next = l2;
                l2 = l2.next;
            } else {
                curNode.next = l1;
                l1 = l1.next;
            }
            curNode = curNode.next;
        }
        if (l1 != null) {
            curNode.next = l1;
        }else {
            curNode.next = l2;
        }

        return dummy.next;
    }

    /**
     *  递归解法
     *  递归的核心方法是将问题规模不断缩小化
     *  合并两个长度为n和m的链表，在value(n) < value(m)可以将规模缩减为合并长度为(n-1)和m的链表
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        if (l1.val > l2.val) {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }else {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;

        }
    }

}
