package tree;

/**
 * 110. 是否为平衡二叉树
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * @author hust_twj
 * @date 2019/10/10
 *
 * 解法：为最大高度的变形{@link MaxDepth_104}
 */
public class IsBalanced_110 {

    // 默认为衡二叉树
    private boolean isBalance = true;
    public boolean isBalanced(TreeNode root) {
        maxHeight(root);
        return isBalance;
    }

    private int maxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = maxHeight(root.left);
        int right = maxHeight(root.right);
        if (Math.abs(left - right) > 1) {
            isBalance = false;
        }
        return Math.max(left, right) + 1;
    }
}
