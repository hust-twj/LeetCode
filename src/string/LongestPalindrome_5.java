package string;


/**
 * 5. 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * Description ：
 * Created by Wenjing.Tang on 2019-10-16.
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */
public class LongestPalindrome_5 {
    public static void main(String[] args) {
        String s = "lejyqjcpluiggwlmnumqpxljlcwdsirzwlygexejhvojztcztectzrepsvwssiixfmpbzshpilmojehqyqpzdylxptsbvkgatzdlzphohntysrbrcdgeaiypmaaqilthipjbckkfbxtkreohabrjpmelxidlwdajmkndsdbbaypcemrwlhwbwaljacijjmsaqembgtdcskejplifnuztlmvasbqcyzmvczpkimpbbwxdtviptzaenkbddaauyvqppagvqfpednnckooxzcpuudckakutqyknuqrxjgfdtsxsoztjkqvfvelrklforpjnrbvyyvxigjhkjmxcphjzzilvbjbvwiwnnkbmboiqamgoimujtswdqesighoxsprhnsceshotakvmoxqkqjvbpqucvafiuqwmrlfjpjijbctfupywkbawquchbclgvhxbanybret";
        // System.out.println(s.substring(0, s.length()-1));
        System.out.println(longestPalindrome1(s));
    }

    /**
     * 暴力法（超时）
     * 滑动窗口思想
     */
    public static String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() <= 1) {
            return s;
        }
        for (int i = s.length(); i > 0; i--) { //控制字符串的长度，不断缩小
            for (int j = 0; j < s.length(); j++) { //滑动窗口，不断遍历
                if (j + i > s.length()) {
                    break;
                }
                String sub = s.substring(j, j + i);
                if (isPalindrome(sub)) {
                    return sub;
                }
            }
        }
        return null;
    }

    /**
     * 动态规划（二维）
     * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
     * 回文串的状态转移方程：dp[l][r] = s[l]==s[r] && dp[l+1]dp[r-1]
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() <= 1) {
            return s;
        }
        //回文串的长度
        int palindromeLength = 1;
        String longestPalindromeStr = s.substring(0, 1);
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int right = 1; right < s.length(); right++) {
            for (int left = 0; left < right; left++) {
                // right - left <= 2 || dp[left + 1][right - 1] 或运算是精华
                // right - left <= 2 说明左右中间，最多只有一个元素，那么一定是回文，就短路
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                    if (palindromeLength < right - left + 1) {
                        palindromeLength = right - left + 1;
                        longestPalindromeStr = s.substring(left, right + 1);
                    }
                }
            }
        }
        return longestPalindromeStr;
    }

    /**
     * 中心扩展算法
     *
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {

        return null;
    }

    private static boolean isPalindrome(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        return s.equals(reverse);
    }

}
