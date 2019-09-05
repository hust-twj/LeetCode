package two_points;

/**
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * Description ：有序数组的平方
 * Created by Wenjing.Tang on 2019-09-05.
 * <p>
 * [-4,-1,0,3,10] --> [0,1,9,16,100]
 * [-7,-3,2,3,11] --> [4,9,9,49,121]
 */
public class SortedSquares {

    public static void main(String[] args) {
        int[] array = new int[]{-7, -3, 2, 3, 11};
        int[] result = sortedSquares(array);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " -> ");
        }

    }

    public static int[] sortedSquares(int[] A) {
        if (A.length == 0) {
            return A;
        }
        int[] result = new int[A.length];
        //双指针
        int start = 0;
        int end = A.length - 1;
        while (start != end) {
            if (A[start] * A[start] >= A[end] * A[end]) {
                result[end - start] = A[start] * A[start];
                start++;
            } else {
                result[end - start] = A[end] * A[end];
                end--;
            }
        }
        result[0] = A[end] * A[end];
        return result;
    }

}
