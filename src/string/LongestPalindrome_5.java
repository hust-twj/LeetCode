package string;

/**
 * 5. 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * Description ：
 * Created by Wenjing.Tang on 2019-10-16.
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */
public class LongestPalindrome_5 {

    /**
     * 动态规划
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s== null) {
            return null;
        }
        if (s.length() <= 1 ) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {

        }

        return null;

    }

    /**
     * 中心扩展算法
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {

        return null;
    }

}
