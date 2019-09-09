package binary_search;


/**
 * https://leetcode-cn.com/problems/search-insert-position/
 * Description ：35. 搜索插入位置
 * Created by Wenjing.Tang on 2019-09-09.
 */
public class SearchInsert_35 {

    public static void main(String[] args) {
        //int[] nums = new int[] {1,2,3,4,5,6,7,5,3,2,1};
        int[] nums = new int[] {1};

        System.out.print(searchInsert(nums, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle;

        while (left <= right) {
            //left 和 right 都解决最大整型时，会整型溢出
            // middle = (left + right) / 2;
            //避免整型溢出
            middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                //key在左侧，更新right
                right = middle - 1;
            } else {
                //key在右侧，更新left
                left = middle + 1;
            }

        }
        //前面与标准的二分查找法一样，最后返回left
        //原因：若比目标值大，left需要右移，而通过 left = middle + 1; 已经右移；
        // 如果比目标值小，left不需要移动，直接返回
        return left;
    }
}
