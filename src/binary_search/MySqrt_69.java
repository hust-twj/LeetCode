package binary_search;

/**
 * https://leetcode-cn.com/problems/sqrtx/submissions/
 * Description ：69. x 的平方根
 * Created by Wenjing.Tang on 2019-09-12.
 * 使用二分法、牛顿法 求解
 */
public class MySqrt_69 {

    public static void main(String[] args) {

        System.out.println(mySqrt(16));
    }

    /**
     * 使用二分法求解
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long left = 1;
        long right = x;
        while (left < right) {
            long middle = left + (right - left) / 2;
            if (middle * middle == x || (middle * middle < x && (middle + 1) * (middle + 1) > x)) {
                return (int)middle;
            }else if (middle * middle > x) {
                right = middle - 1;
            }else {
                left = middle + 1;
            }
        }
        return (int)left;

    }

    /**
     * 使用牛顿法求解
     * @param x
     * @return
     */
    public static int mySqrt1(int x) {
        return 0;

    }

}
