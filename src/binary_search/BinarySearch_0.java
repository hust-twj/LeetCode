package binary_search;

/**
 * 标准的二分查找
 * Description ：
 * Created by Wenjing.Tang on 2019-09-09.
 * 思路：中间的数值与key比较，根据结果决定子区间范围
 */
public class BinarySearch_0 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        System.out.print(BinarySearch(nums, 1));

    }

    public static int BinarySearch(int[] nums, int key) {
        int left = 0;
        int right = nums.length - 1;
        int middle;

        while (left <= right) {
            //left 和 right 都解决最大整型时，会整型溢出
            // middle = (left + right) / 2;
            //避免整型溢出
            middle = left + (right - left) / 2;
            if (nums[middle] == key) {
                return middle;
            } else if (nums[middle] > key) {
                //key在左侧，更新right
                right = middle - 1;
            } else {
                //key在右侧，更新left
                left = middle + 1;
            }
        }
        return -1;
    }
}
