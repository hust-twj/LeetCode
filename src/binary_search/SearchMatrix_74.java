package binary_search;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/submissions/
 * Description ：74. 搜索二维矩阵
 * Created by Wenjing.Tang on 2019-09-18.
 */
public class SearchMatrix_74 {

    public static void main(String[] args) {
        int[][] nums = {{1, 1}};
        System.out.print(searchMatrix(nums, 2));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int left = 0;
        //matrix.length：行 ；matrix[0].length ：列
        int right = matrix.length * matrix[0].length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            //数组转行列式：根据middle位置，获取到对应的行、列（对列取模）
            int row = middle / matrix[0].length;
            int col = middle % matrix[0].length;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return false;
    }
}
