package divide_and_conquer;

import java.util.Arrays;

/**
 * 169. 求众数
 * https://leetcode-cn.com/problems/majority-element/
 * @author hust_twj
 * @date 2019/9/17
 */
public class MajorityElement_169 {

    public static void main(String[] args) {
        int[] nums = new int[] {2,1,2};
        System.out.print(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        //由于存在众数，因此，排序后，中间的数一定为众数
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // TODO: 2019/9/17 分治

}
