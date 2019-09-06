package two_points;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * @author hust_twj
 * @date 2019/9/6
 */
public class Merge_88 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[]{2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || nums2.length == 0) {
            return;
        }
        int[] result = new int[m + n];
        int mPoint = 0;
        int nPoint = 0;

       for (int i = 0; i < m +  n; i++) {
           if (mPoint < m && nums1[mPoint] <= nums2[nPoint]) {
               result[i] = nums1[mPoint];
               mPoint++;
           }else if (nPoint < n){
               result[i] = nums2[nPoint];
               nPoint++;
           }
       }
       nums1 = result;

       for (int i = 0; i < nums1.length; i++)  {
           System.out.print(nums1[i] + " -> ");
       }

    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        //复制数组2到数组1中，数组2从0开始，长度为n，数组1开始的位置为m
        System.arraycopy(nums2, 0, nums1, m, n);
        //排序
        Arrays.sort(nums1);
    }

}
