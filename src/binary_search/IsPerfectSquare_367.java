package binary_search;

/**
 * 367. 有效的完全平方数
 * https://leetcode-cn.com/problems/valid-perfect-square/
 * @author hust_twj
 * @date 2019/9/9
 */
public class IsPerfectSquare_367 {

    public static void main(String[] args) {
        System.out.print(isPerfectSquare(2147483647));
    }

    /**
     * 超时
     * num 很大时，middle * middle可能溢出，结果为负值
     * @param num
     * @return
     */
    public static boolean isPerfectSquare1(int num) {
        int left = 0;
        int right = num;
        while (left  <= right) {
            int middle = left + (right - left) / 2;
            if (middle * middle == num) {
                return true;
            }else if (middle * middle> num) {
                right = middle - 1;
            }else {
                left = middle + 1;
            }
        }
        return false;
    }

    /**
     * 不超时，除法，因为 middle 折半递减
     * @param num
     * @return
     */
    public static boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        while (left  <= right) {
            int middle = left + (right - left) / 2;
            if (middle == num * 1.0 /middle) {
                return true;
            }else if (middle > num * 1.0 /middle) {
                right = middle - 1;
            }else {
                left = middle + 1;
            }
        }
        return false;
    }

}
