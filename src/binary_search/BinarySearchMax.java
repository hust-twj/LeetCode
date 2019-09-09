package binary_search;

/**
 * 先升后降数组找最大值
 * Description ：
 * Created by Wenjing.Tang on 2019-09-09.
 *
 * https://www.cnblogs.com/littlepanpc/p/7704776.html
 *
 * 几种情况：
 * (1) 如果数组先增大再减小，一定有答案。
 *
 * (2) 如果数组单调递增，最后一个元素就是答案。
 *
 * (3) 如果数组单调递简，第一个元素就是答案。
 *
 * (4) 如果数组全部都一样，任何一个元素都是答案，更极端地，如果数组只有一个元素，那么这唯一的元素就是答案。
 *
 * (5) 如果数组出现了几个峰值，那么任何一个峰值都是答案。
 * ————————————————
 * 版权声明：本文为CSDN博主「feliciafay」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/feliciafay/article/details/20586551
 */
public class BinarySearchMax {

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5,6,7,5,3,2,1};
        //int[] nums = new int[] {1,2,3};

        System.out.print(binarySearchMax(nums));
    }

    public static int binarySearchMax(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (middle >= nums.length - 1 || middle <= 0) {
                return middle;
            }
            if (nums[middle] > nums[middle + 1] && nums[middle] > nums[middle -1]) {
                return middle;
            }
            if (nums[middle + 1] > nums[middle]) {
                left = middle + 1;
            }
            if (nums[middle + 1] < nums[middle]) {
                right = middle - 1;
            }
        }
        return -1;
    }

}
