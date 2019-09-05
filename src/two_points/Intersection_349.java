package two_points;

import java.util.*;

/**
 * 349. 两个数组的交集
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * @author hust_twj
 * @date 2019/9/6
 */
public class Intersection_349 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        intersection(nums1, nums2);
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        int[]  result = new int[0];
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return result;
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }

        //交集 set1.retainAll(set2);
        //并集 set1.addAll(set2);
        //差集 set1.removeAll(set2);

        set1.retainAll(set2);

        Object[] objects = set1.toArray();
        result = new int[objects.length];

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
            result[i] = (int)objects[i];
        }
        return result;

    }

}
