package sword_to_offer;

/**
 * Description ：剑指offer 第 10 题：斐波那契数列
 * 0, 1, 1, 2 , 3 ,5 ,8 ,13...
 * Created by Wenjing.Tang on 2020/3/28.
 */
public class Sword2Offer_10 {

    public static void main(String[] args) {

        System.out.println(fib1(11));
        System.out.println(fib2(11));
    }

    /**
     * 方法1：递归求解
     */
    public static int fib1(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    /**
     * 方法2：动态规划，先把前面所有的值求出来并保存在数组，以空间换时间。
     */
    public static int fib2(int n) {

        int[] array = new int[n];
        array[0] = 0;
        array[1] = 1;

        for (int i = 0; i < n - 2; i++) {
            array[i + 2] = array[i + 1] + array[i];
        }
        return array[n - 1];
    }
}
