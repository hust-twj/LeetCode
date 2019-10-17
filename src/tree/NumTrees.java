package tree;

/**
 * 96. 不同的二叉搜索树
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * Description ：
 * Created by Wenjing.Tang on 2019-10-17.
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 */
public class NumTrees {

    public static void main(String[] args) {
        System.out.println(numTrees2(3));

    }

    /**
     * 卡特兰数
     * https://baike.baidu.com/item/catalan/7605685?fr=aladdin
     * 应用：1、出栈次序；2、不同的二叉搜索树；3...
     *
     * 思路：
     * 假设 n 个节点存在二叉搜索树的个数是 f (n)，分别考虑：1 为根节点，2 为根节点，...，n 为根节点 的情况
     * 当 1 为根节点时，其左子树节点个数为 0，右子树节点个数为 n-1；同理当 2 为根节点时，其左子树节点个数为 1，右子树节点为 n-2......
     * 所以可得：f (n) = f(0) * f(n-1) + f(1) * f(n-2)+...+ f(n-1) * f(0)，即为转态转移方程
     * 其中：f(0)为空树，f(0) = 1
     * --> 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786
     *
     * f(n+1) = 2(2n+1)/(n+2)  * f(n)
     *
     * 证明与推导：
     * https://blog.csdn.net/stpeace/article/details/45938477
     *
     *
     */
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }

    /**
     * 公式法:
     * f(n+1) = 2(2n+1)/(n+2)  * f(n)
     * https://leetcode-cn.com/problems/unique-binary-search-trees/solution/xi-xiang-yi-xia-huan-shi-hen-jian-dan-de-by-jerry-/
     */
    public static int numTrees2(int n) {
        int c = 1;
        for (int i = 0; i < n; i++) {
            //注意c写在前面
            c = c * 2 * (2 * i + 1) / ( i + 2);
        }
        return c;
    }


}
