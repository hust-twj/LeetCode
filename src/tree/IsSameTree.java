package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 100. 相同的树
 * https://leetcode-cn.com/problems/same-tree/
 * Description ：
 * Created by Wenjing.Tang on 2019-09-27.
 * <p>
 * 二叉树框架
 * https://leetcode-cn.com/problems/same-tree/solution/xie-shu-suan-fa-de-tao-lu-kuang-jia-by-wei-lai-bu-/
 */
public class IsSameTree {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;

        //System.out.print(isSameTree(treeNode1, treeNode1));

        Deque<Integer> stackQ = new LinkedList<>();
        stackQ.push(1);
        stackQ.push(2);
        stackQ.push(3);
        stackQ.push(4);
        while (!stackQ.isEmpty()) {
            System.out.println(stackQ.pop());
        }

    }

    /**
     * 递归
     *
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        //递归终止条件
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

    /**
     * 栈 迭代
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree2(TreeNode p, TreeNode q) {
        //使用 Deque 替代 Stack
        Deque<TreeNode> stackQ = new LinkedList<>();
        Deque<TreeNode> stackP = new LinkedList<>();
        stackP.push(p);
        stackQ.push(q);

        while (!stackQ.isEmpty() && !stackP.isEmpty()) {
            TreeNode treeNodeP = stackP.pop();
            TreeNode treeNodeQ = stackQ.pop();

            if (treeNodeP == null && treeNodeQ == null) {
                continue;
            }
            if (treeNodeP != null && treeNodeQ != null && treeNodeP.val == treeNodeQ.val) {
                stackP.push(treeNodeP.left);
                stackP.push(treeNodeP.right);

                stackQ.push(treeNodeQ.left);
                stackQ.push(treeNodeQ.right);

            }else {
                return false;
            }

        }
        return stackP.isEmpty() && stackQ.isEmpty();
    }

}
