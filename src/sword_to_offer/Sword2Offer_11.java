package sword_to_offer;

/**
 * Description ：剑指offer 第 11 题：二分查找
 * Created by Wenjing.Tang on 2020/3/28.
 */
public class Sword2Offer_11 {

    private int binarySearch(int[] array, int key) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (array[middle] == key) {
                return middle;
            } else if (array[middle] > key) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
