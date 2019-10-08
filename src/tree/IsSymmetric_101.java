package tree;

/**
 * 101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 * Description ：
 * Created by Wenjing.Tang on 2019-10-08.
 */
public class IsSymmetric_101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    /**
     * 判断两个二叉树是否镜像对称（递归）
     * https://leetcode-cn.com/problems/symmetric-tree/solution/hua-jie-suan-fa-101-dui-cheng-er-cha-shu-by-guanpe/
     *
     * @param leftTree 左子树
     * @param rightTree 右子树
     * @return 是否镜像对称
     */
    private boolean isMirror(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null) {
            return true;
        }
        if (leftTree == null || rightTree == null) {
            return false;
        }
        return leftTree.val == rightTree.val && isMirror(leftTree.left, rightTree.right) && isMirror(leftTree.right, rightTree.left);
    }

}
