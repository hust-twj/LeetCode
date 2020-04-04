package advanced;

/**
 * Description ：
 * Created by Wenjing.Tang on 2020/4/4.
 */
public class NQuene {

    private static final int N = 4;
    
    //一维数组与二维数映射：数组下标为行，数组值为列
    private static int[] array = new int[N];

    static int sum = 0;

    /**
     * 回溯寻找
     */
    static void backTack(int row) {
        if (row == N) {
            for (int i = 0; i < array.length; i++) {
                System.out.print("x[" + i + "] = " + array[i] + ",");
            }
            System.out.println();
            sum++;
        } else {
            for (int i = 0; i < N; i++) {
                array[row] = i;
                if (canPlaceQueen(row)) {//如果第n行可以放，继续看n + 1行
                    backTack(row + 1);
                }
            }
        }
    }

    /**
     * 在row行可否放置皇后   0 <= row < N
     */
    private static boolean canPlaceQueen(int row) {
        for (int j = 0; j < row; j++) {
            if (Math.abs(row - j) == Math.abs(array[row] - array[j]) || array[row] == array[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //从第0行开始
        backTack(0);

        System.out.println("总共有多少种方法： " + sum);

    }
    
}
