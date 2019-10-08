package tree;

import java.util.List;

/**
 * 700. 二叉搜索树中的搜索
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 * @author hust_twj
 * @date 2019/10/8
 */
public class SearchBST_700 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        TreeNode treeNode = searchBST(treeNode1, 2);

        List<Integer> list = InorderTraversal_94.inorderTraversal(treeNode);

        for (Integer integer : list) {
            System.out.println(integer + "  ");
        }
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }else if (root.val > val) {
            return searchBST(root.left, val);
        }else {
            return searchBST(root.right, val);
        }
    }

}
