package palindrome;

/**
 * 9. 回文数
 * https://leetcode-cn.com/problems/palindrome-number/
 * @author hust_twj
 * @date 2019/9/19
 */
public class IsPalindrome_9 {

    public static void main(String[] args) {
        int x = -121;
        System.out.print(isPalindrome(x));
    }

    /**
     * 使用字符串处理
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        String original = String.valueOf(x);
        StringBuilder xString = new StringBuilder(original);
        String reverse = xString.reverse().toString();
        return reverse.equals(original);
    }

    /**
     * todo
     *
     * 不使用字符串处理
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        while (x != 0) {
            int last = x % 10;
            x = last;
        }
        return false;
    }


}
