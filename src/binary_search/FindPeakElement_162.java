package binary_search;

/**
 * https://leetcode-cn.com/problems/find-peak-element/
 * Description ：162. 寻找峰值
 * 类似：https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 * Created by Wenjing.Tang on 2019-09-10.
 */
public class FindPeakElement_162 {

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,1};

        System.out.print(findPeakElement(nums));

    }

    /**
     *
     * https://leetcode-cn.com/problems/find-peak-element/solution/hua-jie-suan-fa-162-xun-zhao-feng-zhi-by-guanpengc/
     * 二分查找
     * 由于左右两次均为负无穷，因此大的一侧一定有峰值
     */
    public static int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int middle;

        while (left < right) {
            //left 和 right 都解决最大整型时，会整型溢出
            // middle = (left + right) / 2;
            //避免整型溢出
            middle = left + (right - left) / 2;
           if (nums[middle] > nums[middle + 1]) {
                //key在左侧，更新right
                right = middle;
            } else {
                //key在右侧，更新left
                left = middle + 1;
            }
        }
        return left;
    }
}
