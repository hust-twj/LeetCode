package two_points;

import java.util.HashSet;
import java.util.Set;

/**
 * 287. 寻找重复数
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 * @author hust_twj
 * @date 2019/9/9
 */
public class FindDuplicate_287 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 4, 1, 5};
        System.out.print(findDuplicate(nums));
    }

    /**
     * todo 结果正确，但空间复杂度为O(N)，不满足要求
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i]))  {
                set.add(nums[i]);
            }else {
                return nums[i];
            }

        }
        return -1;
    }

    // TODO: 2019/9/9 快慢指针，循环检测
}
