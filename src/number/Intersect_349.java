package number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 349. 两个数组的交集
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9，4]
 * Created by Wenjing.Tang on 2020/5/5.
 */
public class Intersect_349 {

    public static void main(String[] args) {

        int[] num1 = new int[]{1, 2, 2, 1};
        int[] num2 = new int[]{2,2};

        int[] result = intersect2(num1, num2);

        System.out.println(result.length);
    }

    /**
     * 借助hashmap保存数字出现的次数
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return nums1;
        }
        if (nums2.length == 0) {
            return nums2;
        }

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums1) {
            set.add(num);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums2) {
            if(set.contains(num)) {
                list.add(num);
                //关键，需要删除，防止重复添加
                set.remove(num);
            }
        }

        int[] result = new int[list.size()];
        if (result.length == 0) {
            return result;
        }

        System.out.println(list.toString());

        for (int k = 0; k < result.length; k++) {
            result[k] = list.get(k);
        }
        return result;
    }

}
