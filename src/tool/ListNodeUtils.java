package tool;

/**
 * 链表工具类
 * @author hust_twj
 * @date 2019/9/4
 */
public class ListNodeUtils {

    /**
     * 遍历打印链表
     */
    public static void printListNode(ListNode root){
        ListNode head = root;
        if (root == null) {
            System.out.println("null");
        }
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }

    }

    /**
     * 将数组转换为链表
     */
    public static ListNode convertArray2ListNode(int [] array){
        if (array.length == 0) {
            return new ListNode(-100);
        }
        ListNode root = new ListNode(array[0]);
        if (array.length <= 1) {
            return root;
        }
        ListNode head = root;

        for (int i = 1; i < array.length; i++) {
            ListNode temp = new ListNode(array[i]);
            head.next = temp;
            head = head.next;
        }
        return root;
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
}
