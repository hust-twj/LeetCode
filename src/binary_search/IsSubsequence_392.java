package binary_search;

/**
 *
 * https://leetcode-cn.com/problems/is-subsequence/
 * Description ：392. 判断子序列
 * Created by Wenjing.Tang on 2019-09-10.
 */
public class IsSubsequence_392 {

    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        if (s.length() > t.length()) {
            return false;
        }
        //双指针，分别指向两个字符串首位
        int sPointer = 0;
        int tPointer = 0;
        //相等的字符个数
        int equalsCharCount = 0;
        while (sPointer < s.length() && tPointer < t.length()) {
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                equalsCharCount++;
                sPointer++;
            }
            tPointer++;
        }
        return equalsCharCount == s.length();
    }

}
