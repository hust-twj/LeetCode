package new_coder;

import tree.TreeNode;

/**
 * 对称的二叉树
 * https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb?tpId=13&tqId=11211&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Description ：
 * Created by Wenjing.Tang on 2019-10-17.
 */
public class IsSymmetrical {

    public static boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }

        return isSymmetrical(pRoot.left, pRoot.right);
    }

    public static boolean isSymmetrical(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        //镜像的条件：
        // 1.左右节点值相等
        // 2.对称的子树也是镜像
        return left.val == right.val && isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
    }
}
