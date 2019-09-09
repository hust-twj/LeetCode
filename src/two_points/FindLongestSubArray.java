package two_points;

/**
 * Description ：找到最长的连续子数组
 * Created by Wenjing.Tang on 2019-09-05.
 * 输入：[8,5,4,3,2,1,0,9,6,5,4,3]
 * 输出：6 （最长5,4,3,2,1,0）
 * 思路：双指针i，j，起始位置为0和1，如果连续，右指针j++；不连续，i=j-1，j++
 */
public class FindLongestSubArray {

    public static void main(String[] args) {
        int[] array = new int[]{8,5,4,3,2,1,0,9,6,5,4,3};
        //int[] array = new int[]{1,2,1,0};

        System.out.println(findLongestSubArray(array));

        int[] array2 = new int[]{1,1,2,3};
        //System.out.println(isContinuous(array2, 0, 3));
    }

    public static int findLongestSubArray(int[] array) {
        if (array.length == 0 || array.length == 1) {
            return array.length;
        }
        int start = 0;
        int end = 1;
        int longestLength = 0;
        while (end <= array.length) {
            if (isContinuous(array, start, end)) {
                end++;
            }else {
                int length = end - start;
                if (length > longestLength) {
                    longestLength = length;
                }
                start = end - 1;
                end++;
            }
        }
        return longestLength;
    }

    /**
     * 数组是否连续：相邻两数相差1（倒序、顺序）
     * @param array 输入数组
     * @param start 数组起始位置
     * @param end 数组终止位置
     * @return true：连续
     */
    private static boolean isContinuous(int[] array, int start, int end) {
        if (start < 0 || end >= array.length) {
            return false;
        }
        int i = start;
        //倒序的连续数，如 3 2 1 0
        int reverseCount = 0;
        //顺序的连续数，如 0 1 2 3
        int orderCount = 0;
        while (i <= end - 1) {
            if (array[i] - array[i + 1] == 1) {
                reverseCount++;
            }else if (array[i] - array[i + 1] == -1) {
                orderCount++;
            }
            i++;
        }
       //System.out.println(orderCount + "  " + reverseCount);
        if (reverseCount == (end - start) || orderCount == (end - start)) {
            return true;
        }
        return false;
    }

}
