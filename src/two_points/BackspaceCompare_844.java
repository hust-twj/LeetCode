package two_points;

import java.util.Stack;

/**
 * 844. 比较含退格的字符串
 * https://leetcode-cn.com/problems/backspace-string-compare/
 * @author hust_twj
 * @date 2019/9/6
 */
public class BackspaceCompare_844 {

    public static void main(String[] args) {
        String s1 = "a#c";
        String s2 = "";
        System.out.print(backspaceCompare(s1, s2));
    }

    /**
     * 利用正则表达式
     *
     * @param S
     * @param T
     * @return
     */
    public static boolean backspaceCompare(String S, String T) {
        String s1 = clear(S);
        String s2 = clear(T);
        return s1.equals(s2);
    }

    private static String clear(String s) {
        if (s.isEmpty() || !s.contains("#")) {
            return s;
        }

        while (s.contains("#")) {
            s = s.replaceFirst(".#", "");
            if (s.startsWith("#")) {
                s = s.replaceFirst("#", "");
            }
        }
        System.out.println(s);
        return s;
    }

    /**
     * todo 利用栈  栈顶如果是要加入"#"，则出栈一个元素；"#"号不加进去
     * 也可以用 StringBuilder模拟栈
     * @param S
     * @param T
     * @return
     */
    public static boolean backspaceCompare2(String S, String T) {
        Stack<Character> s = new Stack<>();
        Stack<Character> t = new Stack<>();
        for (Character c : S.toCharArray()) {
            if (c == '#' && !s.isEmpty()) { //如果取到的是"#"，则需要出栈一个元素；
                s.pop();
            }else if (c != '#') {// "#"不能入栈
                s.push(c);
            }
        }
        for (Character c : T.toCharArray()) {
            if (c == '#' && !t.isEmpty()) {
                t.pop();
            } else if (c != '#') {
                t.push(c);
            }
        }
        if (s.size() != t.size()) {
            return false;
        }
        while (!s.isEmpty() && !t.isEmpty() ) {
            if (s.pop() != t.pop())
                return false;
        }
        return true;
    }

}
