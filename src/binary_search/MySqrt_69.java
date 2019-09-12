package binary_search;

/**
 * https://leetcode-cn.com/problems/sqrtx/submissions/
 * Description ：69. x 的平方根
 * Created by Wenjing.Tang on 2019-09-12.
 * 使用二分法、牛顿法 求解
 */
public class MySqrt_69 {

    public static void main(String[] args) {

        System.out.println(mySqrt3(8));
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
        //使用long，防止做乘法的时候溢出
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
     * 使用二分法求解
     * 右中位数，右指针减一
     * @param x
     * @return
     */
    public static int mySqrt2(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        //使用long，防止做乘法的时候溢出
        long left = 1;
        long right = x;
        while (left < right) {
            long middle = (left + right + 1) >>> 1;
            if (middle * middle > x) {
                right = middle - 1;
            }else {
                left = middle;
            }
        }
        return (int)left;
    }


    /**
     * 使用牛顿法求解
     * 迭代公式：x = 1/2 * (x + N/x)，即切线与x轴交点的坐标位置
     * https://www.zhihu.com/question/20690553
     * @param N
     * @return
     */
    public static double mySqrt3(int N) {
        double x = N;
        while (x * x > N) {
            //迭代，不断减小x的值，最终逼近所求的平方根
            x = (x + N / x) / 2;
            if (x * x - N < 1e-6) {
                return x;
            }
        }
        return x;
    }

    public static int mySqrt4(int N) {
        double x = N;
        while (x * x > N) {
            //迭代
            x = (x + N / x) / 2;
        }
        return (int)x;
    }


}
