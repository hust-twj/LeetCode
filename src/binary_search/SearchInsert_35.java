package binary_search;


/**
 * https://leetcode-cn.com/problems/search-insert-position/
 * Description ：35. 搜索插入位置
 * Created by Wenjing.Tang on 2019-09-09.
 */
public class SearchInsert_35 {


    public static void main(String[] args) {
        //int[] nums = new int[] {1,2,3,4,5,6,7,5,3,2,1};
        int[] nums = new int[] {1,3,5,6};

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

        System.out.println(left + "  " + right);

        //相遇了还没有找到
        if (left == right) {
            if (nums[left] > target) {
                if (left == 0) {
                    return 0;
                }else {
                    return left - 1;
                }
            }else {
                return left + 1;
            }
        }

        return -1;
    }
}
