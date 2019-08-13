package tool;

/**
 * 单向链表节点
 * Created by Wenjing.Tang on 2019-08-13.
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    /**
     * 生成默认列表
     * @return
     */
    public static ListNode generateListNode() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        return head;
    }

    /**
     * 循环打印ListNode
     * @param listNode ListNode
     */
    public static void printListNode(ListNode listNode) {
        if (listNode == null) {
            System.out.print("Node 为 null");
            return;
        }
        System.out.print(listNode.val);
        if (listNode.next != null) {
            System.out.print("->");
        }
        while (listNode.next != null) {
            System.out.print(listNode.next.val);
            if (listNode.next.next != null) {
                System.out.print("->");
            }
            listNode = listNode.next;
        }
        System.out.println();
    }

}
