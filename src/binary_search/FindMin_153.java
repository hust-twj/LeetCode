package binary_search;

/**
 * 153. 寻找旋转排序数组中的最小值
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * @author hust_twj
 * @date 2019/9/9
 */
public class FindMin_153 {

    public static void main(String[] args) {
        int[] nums = new int[] {1,2};
        System.out.print(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int middle;
        //排除全部递增序列
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }

        while (left <= right) {
            //避免整型溢出
            middle = left + (right - left) / 2;
            if (nums[left] < nums[middle]) {
                left = middle;
            }else if (nums[left] > nums[middle]) {
                right = middle;
            }else {
                return nums[left+1];
            }
        }
        return -1;
    }
}
