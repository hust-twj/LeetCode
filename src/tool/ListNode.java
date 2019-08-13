package tool;

/**
 * 链表节点
 * Created by Wenjing.Tang on 2019-08-13.
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
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
            listNode.next = listNode.next.next;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        ListNode node = next;
        while (node != null) {
            sb.append(val);
            sb.append("->");
            node = node.next;
        }
        return sb.toString();
    }
}
