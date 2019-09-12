package binary_search;

/**
 * 标准的二分查找
 * Description ：
 * Created by Wenjing.Tang on 2019-09-09.
 * 思路：中间的数值与key比较，根据结果决定子区间范围
 *
 * 注意：
 * 1、当数组个数为偶数时：
 *    middle = left + (right - left) / 2;得到左中位数的索引；
 *    middle = left + (right - left + 1) / 2;得到右中位数的索引；
 * 2、
 */
public class BinarySearch_0 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        System.out.print(BinarySearch(nums, 1));

    }

    /**
     * 经典二分查找
     * @param nums
     * @param key
     * @return
     */
    public static int BinarySearch(int[] nums, int key) {
        int left = 0;
        int right = nums.length - 1;
        int middle;

        while (left <= right) {
            //left 和 right 都解决最大整型时，会整型溢出
            // middle = (left + right) / 2;
            //避免整型溢出
            middle = left + (right - left) / 2;
            if (nums[middle] == key) {
                return middle;
            } else if (nums[middle] > key) {
                //key在左侧，更新right
                right = middle - 1;
            } else {
                //key在右侧，更新left
                left = middle + 1;
            }
        }
        return left;
    }

    /**
     * 神奇的二分查找 模板
     * https://www.liwei.party/2019/06/17/leetcode-solution-new/search-insert-position/
     * https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/
     */
    public static int BinarySearch2(int[] nums, int key) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int middle;
        //不要 =，退出循环时，left=right
        while (left < right) {
            //无符号右移，在溢出时也可以得到正确值
            middle = (left + right) >>> 1;
            //若小于目标值，可以将目标值排除，因此收缩左边界
            if (nums[middle] < key) {
                left = middle + 1;
            }else {
                //两个分支，右边界不收缩（ middle不+1），不然目标值可能被排除
                right = middle;
            }
        }
        return left;
    }

    /**
     * 分治算法 来进行二分查找
     */
    public static int BinarySearch3(int[] nums, int key) {
        return 0;
    }

}
