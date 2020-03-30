package sword_to_offer;

/**
 * Description ：剑指offer 56 题：数组中数字出现的次数
 * Created by Wenjing.Tang on 2020/3/29.
 */
public class Sword2Offer_56 {

    public static void main(String[] args) {

        int[] input = new int[]{3, 1, 5, 1, 3, 4, 4};
        int result = singleNumber1(input);
        System.out.println(result);
    }

    /**
     * 数组中，只有一个数出现了1次，其余数字都出现了偶数次，找到仅出现一次的数
     * 异或：a ^ a = 0 ;  a ^ 0 = a;
     */
    private static int singleNumber1(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int result = 0;
        //循环，将所有数据异或，最后剩余的数据即为 出现一次的数
        for (int i = 0; i < array.length; i++) {
            result ^= array[i];
        }
        return result;
    }
}
