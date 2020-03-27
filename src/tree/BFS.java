package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description ：二叉树层序遍历（广搜）
 * Created by Wenjing.Tang on 2020/3/28.
 */
public class BFS {

    /**
     * 二叉树层序遍历
     *      1
     *    /  \
     *   2    3
     *  / \  / \
     * 4  5 6   7
     * 输出：1-2-3-4-5-6
     */
    public static void bfs(TreeNode treeNode) {
        if (treeNode == null) {
            System.out.println("null");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            System.out.println(head.val);
            if (head.left != null) {
                queue.add(head.left);
            }
            if (head.right != null) {
                queue.add(head.right);
            }
        }
    }

}
