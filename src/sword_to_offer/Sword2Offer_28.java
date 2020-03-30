package sword_to_offer;

import tree.TreeNode;

/**
 * Description ：剑指offer 第 28 题：二叉树的镜像
 * Created by Wenjing.Tang on 2020/3/29.
 */
public class Sword2Offer_28 {

    private static void mirrorTree(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        //交换左右两个子节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) {
            mirrorTree(root.left);
        }
        if (root.right != null) {
            mirrorTree(root.right);
        }
    }

}
