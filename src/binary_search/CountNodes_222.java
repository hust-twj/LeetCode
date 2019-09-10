package binary_search;

import tree.TreeNode;

/**
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 * Description ：222. 完全二叉树的节点个数
 * Created by Wenjing.Tang on 2019-09-10.
 */
public class CountNodes_222 {

    private static int count = 1;

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

        System.out.print(countNodes(treeNode1));
    }

    /**
     * 方法1：递归，分别递归求左右子树的节点数
     */
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            count++;
            countNodes(root.left);
        }
        if (root.right != null) {
            count++;
            countNodes(root.right);
        }
        return count;
    }

    /**
     * 方法1：递归
     * 递归式：总节点数 = 左节点数 + 右节点数 + 1
     */
    public int countNodes2(TreeNode root) {
        if (root == null){
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

}
