package string;

/**
 * Description ：验证回文串（不删除）
 * https://github.com/MisterBooo/LeetCodeAnimation/blob/master/notes/LeetCode%E7%AC%AC125%E5%8F%B7%E9%97%AE%E9%A2%98%EF%BC%9A%E9%AA%8C%E8%AF%81%E5%9B%9E%E6%96%87%E4%B8%B2.md
 * 思路：涉及到正反的对称性，使用双指针的思想
 * Created by Wenjing.Tang on 2019-08-15.
 */
public class IsPalindrome {

    public static void main(String[] args) {
        String s = "9race a car,   9";
        System.out.println(isPalindrome(s));

    }

    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            //第一种情况
            if (isValid(s.charAt(start)) &&
                    isValid(s.charAt(end)) &&
                    String.valueOf(s.charAt(start)).toLowerCase().equals(String.valueOf(s.charAt(end)).toLowerCase())) {
                 return true;
            }else if (isValid(s.charAt(start)) &&
                    isValid(s.charAt(end))) {
                start++;
                end--;
            }else if (isValid(s.charAt(start))) {
                start++;
            }else {
                end--;
            }
        }

        return false;
    }

    private static boolean isValid(char c) {
        //return (c >= 'a' && c<= 'z') || (c >= 'A' && c<= 'Z') || (c >= '0' && c<= '9');
        return Character.isLetterOrDigit(c);
    }
}
