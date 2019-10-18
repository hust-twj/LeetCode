package new_coder;

import tree.TreeNode;


/**
 * 二叉树的镜像
 * https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011?tpId=13&tqId=11171&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Description ：
 * Created by Wenjing.Tang on 2019-10-17.
 *
 * 反转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class Mirror {

    public static void Mirror(TreeNode root) {
        Mirrors(root);
    }

    public static TreeNode Mirrors(TreeNode root) {
        //空树
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        //保存左右节点地址
        TreeNode left = root.left;
        TreeNode right = root.right;
        //交换左右节点
        root.left = Mirrors(right);
        root.right = Mirrors(left);
        return root;
    }
}
