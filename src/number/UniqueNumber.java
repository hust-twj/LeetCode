package number;

/**
 * Description ：
 * 有一个有序递增序列，求有多少个不同的数字。比如 [1, 5, 7, 7, 8, 9, 9]。
 * 里面总共有5个不同的数字:1, 5, 7, 8, 9
 * Created by Wenjing.Tang on 2020/4/29.
 */
public class UniqueNumber {
    public static void main(String[] args) {
        int[] num = new int[]{1, 1, 2, 7, 7, 7, 9, 10, 10, 10, 12};
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + "  ");
        }

        System.out.println("结果：");

        getUniqueNumber(num);
    }

    public static void getUniqueNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        if (nums.length == 1) {
            System.out.println(nums[0]);
            return;
        }
        //双指针
        int i = 0;
        int j = 1;
        //临界点
        int result = 0;
        while (j < nums.length) {
            //i 和 j 不相等
            // 有两种情况，1是相邻两数不相等；2是不相邻两数不相等
            if (nums[i] != nums[j]) {
                //如果第个i位置与i+1个位置相等，交换i+1和j位置（相邻两数不相等）
                if (nums[i] >= nums[i + 1] && j - i > 1) {
                    int temp = nums[i + 1];
                    nums[i + 1] = nums[j];
                    nums[j] = temp;
                }
                i++;
            }
            j++;
            result = i;
        }

        for (int k = 0; k <= result; k++) {
            System.out.print(nums[k] + "  ");
        }
    }
}
