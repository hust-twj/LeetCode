package list;

import tool.ListNode;
import tool.ListNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *  回文链表
 *  https://leetcode-cn.com/problems/palindrome-linked-list/
 * @author hust_twj
 * @date 2019/9/4
 */
public class IsPalindrome {

    public static void main(String[] args) {
        int[] array = new int[]{-12,1,-12};

        ListNode listNode = ListNodeUtils.convertArray2ListNode(array);
        System.out.println(isPalindrome(listNode));
    }

    /**
     * 有带优化
     * 时间复杂度：O(N) 空间复杂度：O(N)，
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode current = head;
        List<Integer> list = new ArrayList<>();
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        int i = 0, j = list.size() - 1;
        while (i <= j)  {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }else {
                i++;
                j--;
                if (i>=j) {
                    return true;
                }
            }
        }
        return false;
    }
}
