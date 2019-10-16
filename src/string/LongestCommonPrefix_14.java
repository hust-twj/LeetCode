package string;

/**
 * 14. 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * @author hust_twj
 * @date 2019/8/15
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 */
public class LongestCommonPrefix_14 {

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    /**
     * 方法1，水平扫描
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        //令最长公共前缀为第一个字符串；如果不是，缩短长度并迭代
        String result = strs[0];
        int index = result.length();
        if (strs.length == 1) {
            return result;
        }

        for (int i = 1; i < strs.length; ) {
            while (i < strs.length ) {
                if (!strs[i].startsWith(result)) {
                    i = 1;
                    index--;
                    result = result.substring(0, index);
                    break;
                }else {
                    i++;
                }
            }
            if (i == strs.length) {
                return result;
            }
        }
        return result;
    }

    /**
     * 方法2：分治
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        return "";
    }

    private static String longestCommonPrefix2(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        }
        int middle = left + (right - left) / 2;
        String leftStr = longestCommonPrefix2(strs, left, middle);
        String rightStr = longestCommonPrefix2(strs, middle, right);
        return commonPrefix(leftStr, rightStr);
    }

    /**
     * 求两个子串的最长前缀
     * @param left
     * @param right
     * @return
     */
    private static String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }

}
