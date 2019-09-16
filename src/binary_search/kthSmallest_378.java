package binary_search;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * Description ：378. 有序矩阵中第 K 小的元素
 * Created by Wenjing.Tang on 2019-09-16.
 */
public class kthSmallest_378 {

    public static void main(String[] args) {
        int[][] intArray = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(kthSmallest(intArray, 2));
    }

    /**
     * 二分查找
     */
    public static int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[row - 1][col - 1];
        while (left < right) {
            // 每次循环都保证第K小的数在start~end之间，当start==end，第k小的数就是start
            int mid = (left + right) / 2;
            // 找二维矩阵中<=mid的元素总个数
            int count = findNoBiggerThanMid(matrix, mid, row, col);
            if (count < k) {
                // 第k小的数在右半部分，且不包含mid
                left = mid + 1;
            } else {
                // 第k小的数在左半部分，可能包含mid
                right = mid;
            }
        }
        return right;
    }

    /**
     * 找到小于或等于mid的个数
     */
    private static int findNoBiggerThanMid(int[][] matrix, int mid, int row, int col) {
        // 以列为单位找，找到每一列最后一个<=mid的数即知道每一列有多少个数<=mid
        int i = row - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < col) {
            if (matrix[i][j] <= mid) {
                // 第j列有i+1个元素<=mid
                count += i + 1;
                j++;
            } else {
                // 第j列目前的数大于mid，需要继续在当前列往上找
                i--;
            }
        }
        return count;
    }

    // TODO: 2019/9/16 最小堆排序

}
