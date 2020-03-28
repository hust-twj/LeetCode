package sword_to_offer;

/**
 * Description ：剑指offer 第 14 题：剪绳子
 * <p>
 * n = 2 --> 1(1*1)
 * n = 3 --> 2(1*2)
 * n = 4 --> 4(2*2)
 * n = 5 --> 6(2*3)
 * n = 6 --> 9(3*3)
 * n = 7 --> 12(3*4)
 * n = 8 --> 18(2*3*3)
 * Created by Wenjing.Tang on 2020/3/28.
 */
public class Sword2Offer_14 {

    public static void main(String[] args) {
        System.out.println(maxProductAfterCutting(8));

    }

    private static int maxProductAfterCutting(int length) {
        // 长度为1时不满足题意，返回0
        if (length < 2) {
            return 0;
        }
        // f(2)
        if (length == 2) {
            return 1;
        }
        // f(3)
        if (length == 3) {
            return 2;
        }
        // 加1是因为需要访问到products[length]
        int[] products = new int[length + 1];
        // 下面这三个存的不是f(1)、f(2)、f(3)，只是单纯的长度而已
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        // 从products[4]到products[length]放的是f(4)~f(n)的值
        for (int i = 4; i <= length; i++) {
            int max = 0;

            // 对所有相乘情况进行遍历求出f(i)的最优解
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (product > max) {
                    max = product;
                }
            }
            // 得到f(i)的最优解
            products[i] = max;
        }
        // 返回f(n)
        return products[length];
    }
}
