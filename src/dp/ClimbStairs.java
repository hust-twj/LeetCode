package dp;

/**
 * 动态规划核心：递归式（状态转移方程） + 边界条件
 * Description ：动态规划--爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 * Created by Wenjing.Tang on 2019-08-14.
 *
 * 解析：第n步，要么从第n-1爬上来，要么从第n-2步爬上来
 * 因此，得到状态转移方程：f(n) = f(n-1) + f(n-2)
 */
public class ClimbStairs {

    public static void main(String[] args) {

        int result = climbStairs2(40);
        System.out.println(result);
    }

    /**
     * 方法1
     * 递归：时间复杂度O(2^n)
     * 然鹅，递归后，冗余计算太多导致超时
     * @param n 楼梯阶数
     * @return 种数
     */
    public static int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }

    /**
     * 方法2
     * 空间换时间：采用数组 缓存
     * https://blog.csdn.net/My_Jobs/article/details/43535179
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        //为了让下标对应，去n+1个数
        int[]  result = new int[n+1];
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            result[i] = result[i-1] + result[i-2];
        }
        return result[n];
    }

}
