package string;

/**
 * 公共类
 * Created by Wenjing.Tang on 2019-08-14.
 */
public class ANormal {

    public static void main(String[] args) {
        String s = ", , , ,        a, eaefa";
        String s2 ="                ";

        System.out.println(countSegments(s2));

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
        String s2 = s1.replaceAll(" +", " ");
        return s2.split(" ").length;

    }
}
