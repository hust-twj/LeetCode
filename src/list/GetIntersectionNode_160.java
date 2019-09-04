package list;

import tool.ListNode;

import java.util.Stack;

/**
 * 相交链表
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * @author hust_twj
 * @date 2019/9/4
 */
public class GetIntersectionNode_160 {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != null && nodeB != null && nodeA != nodeB) {
            nodeA = (nodeA.next == null) ? headB : nodeA.next;
            nodeB = (nodeB.next == null) ? headA : nodeB.next;
        }
        return nodeA;
    }

    /**
     * 使用栈
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        //建立两个栈
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        //入栈
        while (nodeA != null) {
            stackA.push(nodeA);
            nodeA = nodeA.next;
        }
        while (nodeB != null) {
            stackB.push(nodeB);
            nodeB = nodeB.next;
        }
        //出栈 并 比较
        ListNode popNodeA, popNodeB;
        //记录上一次出栈的重复节点
        ListNode previousPopNode = null;
        //是否有相交节点
        boolean hasIntersectionNode = false;
        while (stackA.peek() != null && stackB.peek() != null && !stackA.isEmpty() && !stackB.isEmpty()) {
             popNodeA  = stackA.pop();
             popNodeB = stackB.pop();
            if (popNodeA == popNodeB) {
                hasIntersectionNode = true;
                previousPopNode = popNodeA;
                //边界情况，类似1->2  1->2 这种等长且节点全部相等的情况
                if (stackA.isEmpty() || stackB.isEmpty()) {
                    return previousPopNode;
                }
            }
            //有相交节点，并且下一次出栈的节点不同，说明上一次的节点就是相交节点
            if (hasIntersectionNode && popNodeA != popNodeB) {
                return previousPopNode;
            }
        }
        return null;
    }
}
