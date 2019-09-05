package two_points;

/**
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * 两数之和 II - 输入有序数组
 * @author hust_twj
 * @date 2019/9/6
 */
public class TwoSum_167 {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 7, 11, 15};
        int[] result =  twoSum(nums, 9);
        System.out.println(result[0] +"  " + result[1]);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0, right = numbers.length  - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            }else if (numbers[left] + numbers[right] < target) {
                left++;
            }else {
                result[0] = left + 1;
                result[1] = right +1;
                return result;
            }
        }
        return result;
    }

}