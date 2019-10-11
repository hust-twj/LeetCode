package tree;

import java.util.*;

/**
 * 107. 二叉树的层次遍历 II
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * @author hust_twj
 * @date 2019/10/10
 */
public class LevelOrderBottom_107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        //队列 add / poll
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> sub = new ArrayList<>();
            //遍历每一层
            int count = queue.size();
            // 注意：
            // 不能写成 for (int i = 0; i < queue.size(); i++)
            // 不然queue.poll()后queue的大小会变化导致结果错误
            for (int i = 0; i < count; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode != null) {
                    sub.add(treeNode.val);
                    if (treeNode.left != null) {
                        queue.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.add(treeNode.right);
                    }
                }
            }
            //注意顺序，添加到第0个位置
            result.add(0, sub);
        }
        //Collections.reverse(result);
        return result;
    }

}
