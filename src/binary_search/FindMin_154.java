package binary_search;

/**
 * 154. 寻找旋转排序数组中的最小值
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * @author hust_twj
 * @date 2019/9/18
 * 可能存在重复值
 */
public class FindMin_154 {

    public static void main(String[] args) {
        //11000
        int[] nums = new int[] {2,2,2,0,1};
        System.out.print(findMin(nums));
    }

    public static int findMin(int[] nums) {

        //排除全部递增序列
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        int middle;
        while (left < right) {
            middle = left + (right - left) / 2;
           if (nums[middle] > nums[right]) {
               left = middle + 1;
           }else if (nums[middle] < nums[right]) {
               right = middle;
           }else {
               right--;
           }
        }
        return nums[left];
    }
}
