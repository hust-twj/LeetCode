package two_points;

import tool.ArrayUtils;

/**
 * 283. 移动零
 * https://leetcode-cn.com/problems/move-zeroes/
 * @author hust_twj
 * @date 2019/9/6
 */
public class MoveZeroes_283 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,0,0,0,0,0,0,1};

        moveZeroes2(nums1);
    }

    /**
     * 需要比较的次数过多
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[left] != 0 && nums[right] != 0) { //全部不为0，全部右移
                left++;
                right++;
            }else if (nums[left] == 0 && nums[right] == 0) { //全部为0，右指针右移
                right++;
            }else if (nums[left] == 0 && nums[right] != 0) { //左边为0，右边不为0，交换，左指针右移
                nums[left] = nums[right];
                nums[right] = 0;
                left++;
            }
        }
        ArrayUtils.printArray(nums);
    }

    public static void moveZeroes2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        //非0的下标
        int noneZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[noneZeroIndex];
                nums[noneZeroIndex] = temp;
                noneZeroIndex++;
            }
        }
        ArrayUtils.printArray(nums);
    }

}
