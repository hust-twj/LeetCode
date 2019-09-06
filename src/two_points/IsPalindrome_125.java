package two_points;

/**
 * 验证回文串
 * https://leetcode-cn.com/problems/valid-palindrome/
 * @author hust_twj
 * @date 2019/9/6
 */
public class IsPalindrome_125 {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
    public static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) {
            return true;
        }
        String lowerCase = s.toLowerCase();

        int start = 0;
        int end = lowerCase.length() - 1;
        while (start <= end) {
            if (!isChar(lowerCase.charAt(start))) {
                start++;
            }
            if (!isChar(lowerCase.charAt(end))) {
                end--;
            }
            if (isChar(lowerCase.charAt(start)) && isChar(lowerCase.charAt(end))) {
                if (lowerCase.charAt(start) == lowerCase.charAt(end)) {
                    start++;
                    end--;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isChar(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') ;
    }
}
