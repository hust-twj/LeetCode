package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * Description ：
 * Created by Wenjing.Tang on 2019-09-24.
 */
public class InorderTraversal_94 {

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

        System.out.print(inorderTraversal(treeNode1));
    }

    private static List<Integer> list = new ArrayList<>();

    public static List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) {
            return list;
        }

        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }

    private static void dfs(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(result, root.left);
        result.add(root.val);
        dfs(result, root.right);
    }

}
