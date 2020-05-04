package number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 350. 两个数组的交集 II
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2]
 * 输出: [2]
 * Created by Wenjing.Tang on 2020/5/5.
 */
public class Intersect_350 {

    public static void main(String[] args) {

        int[] num1 = new int[]{1, 2, 2, 1};
        int[] num2 = new int[]{2};

        int[] result = intersect3(num1, num2);

        System.out.println(result.length);
    }

    /**
     * 有问题：数组中有重复的时候结果错误
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return nums1;
        }
        if (nums2.length == 0) {
            return nums2;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    list.add(nums1[i]);
                    break;
                }
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
        //key 为 数字， value为数字的格个数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
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

    /**
     * 如果数组有序，双指针
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect3(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return nums1;
        }
        if (nums2.length == 0) {
            return nums2;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] > nums2[j]) {
                j++;
            }else {
                i++;
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
