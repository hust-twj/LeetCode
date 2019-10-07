package tree;

/**
 * 104. 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @author hust_twj
 * @date 2019/10/7
 */
public class MaxDepth_104 {

    public static void main(String[] args) {

    }

    /**
     * DFS（深度优先搜索）
     * 二叉树的的深度等于左 / 右子树的深度的较大值加 1。
     * 即 maxDepth(root)=Max(maxDepth(root->left),maxDepth(root->right))+1
     * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/er-cha-shu-de-zui-da-shen-du-by-leetcode/
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
