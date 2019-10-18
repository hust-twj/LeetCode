package tree;

/**
 * 226. 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * Description ：
 * Created by Wenjing.Tang on 2019-10-08.
 */
public class InvertTree_226 {

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

        System.out.print(invertTree2(treeNode1));
    }

    /**
     * 错误
     * @param root
     * @return
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = invertTree(root.right);
        root.right = invertTree(root.left);
        return root;

    }

    public static TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = invertTree2(left);
        root.left = invertTree2(right);
        return root;
    }

}
