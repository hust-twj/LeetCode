package binary_search;

/**
 * https://leetcode-cn.com/problems/arranging-coins/
 * Description ：441. 排列硬币
 * Created by Wenjing.Tang on 2019-09-11.
 * 推导得出公式：n*(n+1)/2 = A --> 求n
 */
public class ArrangeCoins_441 {

    public static void main(String[] args) {
        System.out.println(arrangeCoins3(10));
    }

    //公式法：2 * n 会超过最大整形
    public static int arrangeCoins1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return (int)(Math.sqrt(2 * n + 0.25d) - 0.5);
    }

    /**
     * 将 2 * n  提到括号外面，避免整型溢出
     * @param n
     * @return
     */
    public static int arrangeCoins2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return (int)(Math.sqrt(2d) * Math.sqrt(n + 1d /8) - 0.5);

    }

    public static int arrangeCoins(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int left = 1;
        int right = n;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (getCount(middle) == n || (getCount(middle) < n) && getCount(middle + 1) > n) {
                return middle;
            }else if (getCount(middle) > n) {
                right = middle;
            }else {
                left = middle;
            }
        }
        return left;

    }

    private static int getCount(int index) {
        return index * (index + 1) / 2;
    }

    /**
     * 迭代求解
     * @param n
     * @return
     */
    public static int arrangeCoins3(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int i = 1;
        while (n >= i) {
            n = n - i;
            i++;
        }
        return i -1;
    }

}
