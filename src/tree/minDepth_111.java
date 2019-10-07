package tree;

/**
 * 111. 二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * @author hust_twj
 * @date 2019/10/7
 */
public class minDepth_111 {

    /**
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量 "
     * 也就是说除非是只有一个根节点，不然的话必须要有一个根节点跟叶子节点才能组成路径。根节点自己不能作为叶子节点
     * 所以 [1,2] 最小深度 2，[1] 最小深度 1
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftHeight = minDepth(root.left);
        int rightHeight = minDepth(root.right);
        if (root.left == null && root.right != null) {
            return rightHeight + 1;
        }

        if (root.right == null && root.left != null) {
            return leftHeight + 1;
        }

        return Math.min(leftHeight, rightHeight) + 1;
    }

}
