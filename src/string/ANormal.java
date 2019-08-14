package string;

/**
 * 公共类
 * Created by Wenjing.Tang on 2019-08-14.
 */
public class ANormal {

    public static void main(String[] args) {
        String s = " Hello World a   ";
        String s2 ="                ";

        //System.out.println(countSegments(s2));
        System.out.println(lengthOfLastWord(s));

    }

    /**
     * 434. 字符串中的单词数
     * https://leetcode-cn.com/problems/number-of-segments-in-a-string/
     * @param s
     * @return
     */
    public static int countSegments(String s) {
        //异常情况真多
        if (s == null || s.isEmpty() || s.trim().isEmpty()) {
            return 0;
        }
        String s1 = s.trim();
        //匹配多个空格，替换为单个
        String s2 = s1.replaceAll(" +", " ");
        return s2.split(" ").length;

    }

    /**
     * 58. 最后一个单词的长度
     * https://leetcode-cn.com/problems/length-of-last-word/
     * @return
     */
    public static int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty() || s.trim().isEmpty()) {
            return 0;
        }
        String s1 = s.trim();
        String s2 = s1.replaceAll(" +", " ");

        String[] result = s2.split(" ");
        return result[result.length - 1].length();
    }
}
