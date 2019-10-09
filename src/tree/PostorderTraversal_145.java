package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * @author hust_twj
 * @date 2019/10/9
 */
public class PostorderTraversal_145 {

    List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            list.add(root.val);
        }
        return list;
    }
        /**
         * 后序遍历（迭代 栈）左--右--根
         * @param root
         * @return
         */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        // TODO: 2019/10/9 注意顺序
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            //和传统先序遍历不一样，先将左结点入栈
            if(node.left != null) {
                stack.push(node.left);
            }
            //后将右结点入栈
            if(node.right != null) {
                stack.push(node.right);
            }

            //index 为0
            list.add(0,node.val);
        }
        return list;
    }

}
