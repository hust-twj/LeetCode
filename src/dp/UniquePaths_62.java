package dp;

/**
 * 62. 不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 *
 * @author hust_twj
 * @date 2019/9/20
 */
public class UniquePaths_62 {

    public static void main(String[] args) {
        System.out.print(uniquePaths2(7, 3)); //1916797311
    }

    /**
     * 递归 超时
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {

        if (m == 1 || n == 1) {
            return 1;
        }
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }

    /**
     * 动态规划
     */
    public static int uniquePaths2(int m, int n) {
        int[][] result = new int[m][n];

        //边界，首列全部为 1
        for (int i = 0; i < m; i++) {
            result[i][0] = 1;
        }

        //边界，首行全部为 1
        for (int j = 0; j < n; j++) {
            result[0][j] = 1;
        }
        //双重循环，求解除边界以外的值
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }
        return result[m - 1][n - 1];
    }

    /**
     * 动态规划（优化版）
     */
    public static int uniquePaths3(int m, int n) {
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = result[i - 1][j] + result[i][j - 1];
                }
            }
        }
        return result[m - 1][n - 1];
    }

}
