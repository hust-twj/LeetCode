package two_points;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 349. 两个数组的交集
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * @author hust_twj
 * @date 2019/9/6
 */
public class Intersection_350 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2};
        int[] result = intersection(nums1, nums2);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+ " ");
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        int[]  result = new int[0];
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return result;
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            list1.add(nums1[i]);
          //  System.out.print(list1.get(i) + " ");
        }

       // System.out.println();

        for (int i = 0; i < nums2.length; i++) {
            list2.add(nums2[i]);
           // System.out.print(list2.get(i)+ " ");
        }

        //交集 set1.retainAll(set2);
        //并集 set1.addAll(set2);
        //差集 set1.removeAll(set2);


        if (list1.size() > list2.size()) {
            list2.retainAll(list1);
            list1 = list2;
        }else {
            list1.retainAll(list2);
        }

      //  System.out.println();

        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i)+ " ");
        }
//        System.out.println();
//        for (int i = 0; i < list2.size(); i++) {
//            System.out.print(list2.get(i)+ " ");
//        }

        Object[] objects = list1.toArray();
        result = new int[objects.length];

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
            result[i] = (int)objects[i];
        }
        return result;

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
