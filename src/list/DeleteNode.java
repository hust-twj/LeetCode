package list;

import tool.ListNode;

/**
 * Description ：删除列表的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * Created by Wenjing.Tang on 2019-08-14.
 */
public class DeleteNode {

    public static void main(String[] args) {

        ListNode listNode = ListNode.generateListNode();

        ListNode.printListNode(listNode);

        deleteNode(listNode);

        ListNode.printListNode(listNode);
    }

    /**
     * 删除节点时，并不知道该节点的前一个节点
     * 可以采用“狸猫换太子”的策略：
     * 即先把该节点的后一个节点的值赋给该节点，然后删除该节点的下一个节点
     *
     * @param node
     */
    private static void deleteNode(ListNode node) {
        //下一个节点的值赋值给该节点
        node.val = node.next.val;
        //删除下一个节点
        node.next = node.next.next;
    }
}
