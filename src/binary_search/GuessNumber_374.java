package binary_search;

/**
 * https://leetcode-cn.com/problems/guess-number-higher-or-lower/
 * Description ：374. 猜数字大小
 * Created by Wenjing.Tang on 2019-09-11.
 */
public class GuessNumber_374 {

    private static int pick = 6;

    public static void main(String[] args) {

        System.out.println(guessNumber(10));
    }

    public static int guessNumber(int n) {
        int left = 1;
        int right = n;
        int middle;

        while (left <= right) {
            //避免整型溢出
            middle = left + (right - left) / 2;
            if (guess(middle) == 0) {
                return middle;
            } else if (guess(middle) < 0) {
                //key在左侧，更新right
                right = middle - 1;
            } else {
                //key在右侧，更新left
                left = middle + 1;
            }
        }
        return left;
    }

    private static int guess(int num) {
        if (num > pick) {
            return  1;
        }else if (num < pick) {
            return  -1;
        }
        return 0;
    }
}

