package two_points;

/**
 * https://leetcode-cn.com/problems/remove-element/
 * Description ：移除元素
 * Created by Wenjing.Tang on 2019-09-05.
 */
public class RemoveElement_27 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};//0,1,2,2,3,0,4,2
        System.out.print(removeElement(nums, 2));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }

}
