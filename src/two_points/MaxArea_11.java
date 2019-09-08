package two_points;

/**
 *
 * https://leetcode-cn.com/problems/container-with-most-water/
 * Description ：11. 盛最多水的容器
 * Created by Wenjing.Tang on 2019-09-07.
 * 面积首先取决于跨度，然后取决于高度。要将高度矮的指针移向高度高的指针。
 */
public class MaxArea_11 {

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.print(maxArea(height));

    }

    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            //计算面积
            int area = Math.min(height[left], height[right]) * (right - left);
            if (area > maxArea) {
                maxArea = area;
            }
            //移动指针位置
            if (height[left] <= height[right]) {
                left++;
            }else {
                right--;
            }

        }
        return maxArea;
    }

}
