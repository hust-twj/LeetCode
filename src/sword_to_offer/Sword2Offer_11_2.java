package sword_to_offer;

/**
 * Description ：剑指offer 第 11 题：旋转数组中最小的数
 * Created by Wenjing.Tang on 2020/3/28.
 */
public class Sword2Offer_11_2 {

    public static void main(String[] args) {
        int[] array = new int[]{6501, 6828, 6963, 7036, 7422, 7674, 8146, 8468, 8704, 8717, 9170, 9359, 9719, 9895,
                9896, 9913, 9962, 154, 293, 334, 492, 1323, 1479, 1539, 1727, 1870, 1943, 2383, 2392, 2996,
                3282, 3812, 3903, 4465, 4605, 4665, 4772, 4828, 5142, 5437, 5448, 5668, 5706, 5725, 6300, 6335};

        System.out.println(array[minNumberInRotateArray(array)]);
    }

    /**
     * 3, 4, 5, 1, 2 --> 1
     * 1-3-2   --> 1
     * 1-2-3  --> 1
     *
     * @param array
     * @return
     */
    public static int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        int middle = 0;
        while (left < right) {
            //均与最右边的值进行对比
            middle = left + (right - left) / 2;
            if (array[middle] > array[right]) {
                left = middle + 1;
            } else if (array[middle] < array[right]) {
                right = middle;
            } else {
                right--;
            }
        }
        return array[right];
    }
}
