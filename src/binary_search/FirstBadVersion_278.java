package binary_search;

/**
 * https://leetcode-cn.com/problems/first-bad-version/
 * Description ：278. 第一个错误的版本
 * Created by Wenjing.Tang on 2019-09-11.
 */
public class FirstBadVersion_278 {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(2));
    }
    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (isBadVersion(middle) && (middle > 0 && !isBadVersion(middle-1))) {
                return middle;
            }else if (!isBadVersion(middle)) {
                left = middle + 1;
            }else {
                right = middle - 1;
            }
        }
        return left;

    }

    private static boolean isBadVersion(int version) {
        switch (version) {
            case 1:
                return false;
            case 2:
                return true;
//            case 3:
//                return true;
//            case 4:
//                return true;
            default:
                break;
        }
        return false;
    }

}
