package string;

import java.util.Deque;
import java.util.Stack;

/**
 * 20. 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 * @author hust_twj
 * @date 2019/10/7
 */
public class IsValid_20 {

    public static void main(String[] args) {
        String s = "{[]}";
        System.out.print(isValid(s));
    }

    /**
     * 使用栈
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }
            if ((stack.peek() == '(' && s.charAt(i) == ')')  ||
                    (stack.peek() == '[' && s.charAt(i) == ']') ||
                    (stack.peek() == '{' && s.charAt(i) == '}')) {
               stack.pop();
            }else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }


}
