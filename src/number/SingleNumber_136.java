package number;

import java.util.HashMap;
import java.util.Map;

/**
 * 136. 只出现一次的数字
 * https://leetcode-cn.com/problems/single-number/
 * @author hust_twj
 * @date 2019/9/20
 */
public class SingleNumber_136 {

    public static void main(String[] args) {
        int[] nums = new int[] {4,2,4,4,5,3};
        System.out.print(singleNumber(nums));
    }

    /**
     * 方法1：使用哈希表，存所有的元素的个数
     * 额外空间
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    /**
     * todo
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums) {
        return 0;
    }
}
