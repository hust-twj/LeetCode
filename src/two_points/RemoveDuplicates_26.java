package two_points;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * Description ：删除排序数组中的重复项
 * Created by Wenjing.Tang on 2019-09-05.
 */
public class RemoveDuplicates_26 {

    public static void main(String[] args) {
        int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
        System.out.print(removeDuplicates(nums));

    }

    /**
     * 双指针，跳跃式
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int left = 0;
        int right = left + 1;
        while (right < nums.length) {
            if (nums[left] == nums[right]) {
                //两数相等，则右指针右移
                right++;
            }else {
                //两数不等，左边指针右移，则先将后面的元素移动到前面，再将右指针右移
                left++;
                nums[left] = nums[right];
                right++;
            }
        }
//        for (int i = 0; i < nums.length; i++) {
//            System.out.print(nums[i] + " -> ");
//        }
        return left + 1;
    }
}
