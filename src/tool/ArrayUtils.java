package tool;

/**
 * @author hust_twj
 * @date 2019/9/6
 */
public class ArrayUtils {
    public static void main(String[] args) {

    }

    /**
     * 打印数组
     * @param nums
     */
    public static void printArray(int[] nums) {
        System.out.print("[ ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i != nums.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

}
