package new_coder;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&tqId=11158&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Description ：
 * Created by Wenjing.Tang on 2019-10-21.
 */
public class Push_Pop {

    //stack1为队列的入口；stack2为队列的出口
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    /**
     * 入队
     */
    public void push(int node) {
        stack1.push(node);
    }

    /**
     * 出队：现将栈stack1 pop取出，
     */
    public int pop() {
        //判空：边界条件，两个栈都为空，无法出队
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("empty");
        }

        if (stack2.isEmpty()) {
            //将1的数入栈到2中，这样栈2的顺序即为队列
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
