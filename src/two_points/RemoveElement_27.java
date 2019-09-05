package two_points;

/**
 * https://leetcode-cn.com/problems/remove-element/
 * Description ：移除元素
 * Created by Wenjing.Tang on 2019-09-05.
 */
public class RemoveElement_27 {

    public static void main(String[] args) {
        int[] nums = new int[]{0};//0,1,2,2,3,0,4,2
        System.out.print(removeElement(nums, 0));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] == val) {
                left++;
                nums[left] = nums[right];
                right++;
            }else {

            }
//            if (left == right) {
//                //左右指针相等且值不低于指定值
//                if (nums[right] != val) {
//                    left++;
//                    right++;
//                } else {
//                    right++;
//                    if (right < nums.length) {
//                        nums[left] = nums[right];
//                    }
//
//                }
//            } else {
//                if (nums[right] == val) {
//                    right++;
//                } else {
//                    left++;
//                    if (left < nums.length) {
//                        nums[left] = nums[right];
//                    }
//                    right++;
//                }
//
//            }
        }
        return left;
    }

}
