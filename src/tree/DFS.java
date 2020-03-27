package tree;

import java.util.Stack;

/**
 * Description ：二叉树深度优先遍历遍历（深搜）
 * Created by Wenjing.Tang on 2020/3/28.
 */
public class DFS {

    /**
     * 二叉树深度优先搜索(先、中、后序方式)
     *    1
     *  /   \
     *  2    3
     * / \   / \
     * 4  5 6   7
     * 输出：1-2-4-5-3-6-7（先序：根--坐--右）
     */
    public void dfs_pre(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.val + "  ");
        dfs_pre(treeNode.left);
        dfs_pre(treeNode.right);
    }

    /**
     * 中序-递归
     * 左--根--右
     * 4-2-5-1-6-3-7
     *
     */
    public void dfs_mid(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        dfs_mid(treeNode.left);
        System.out.print(treeNode.val + "  ");
        dfs_mid(treeNode.right);
    }


    /**
     * 后序-递归
     */
    public void dfs_end(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        dfs_end(treeNode.left);
        dfs_end(treeNode.right);
        System.out.print(treeNode.val + "  ");
    }

    /**
     * 前序--非递归(借助栈)
     * @param head
     */
    public void dfs_pre2(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.right);
            }
        }
    }

    /**
     * 中序--非递归(借助栈)
     * @param head
     */
    public void dfs_mid2(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            // TODO: 2020/3/28
            //https://www.iteye.com/blog/uule-2420373

        }
    }

}
