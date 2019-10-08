package tree;

/**
 * 559 N 叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 * @author hust_twj
 * @date 2019/10/8
 */
public class MaxDepth_559 {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children.isEmpty()) {
            return 1;
        }
        int depth = 0;

        //循环，递归求每个分支的最大深度
        for (int i = 0; i < root.children.size(); i++) {
            depth = Math.max(maxDepth(root.children.get(i)), depth);
        }

        return depth + 1;

    }
}
