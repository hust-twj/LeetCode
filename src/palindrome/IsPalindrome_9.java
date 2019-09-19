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
     *
     * 不使用字符串处理
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        int revertedNumber = 0;
        while(x > revertedNumber) {
            //得到反转的
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber/10;
    }

}
