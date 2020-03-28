package sword_to_offer;

import java.util.Stack;

/**
 * Description ：剑指offer 第 9 题：用两个栈实现队列
 * Created by Wenjing.Tang on 2020/3/28.
 */
public class Sword2Offer_9<T> {

    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    /**
     * 队列入队
     *
     * @param t 入队的元素
     */
    public void push(T t) {
        stack1.push(t);
    }

    /**
     * 队列出队
     * 两个栈无非就4中情况：全部为空；1为空，2不为空；1不为空，2为空；全部不为空
     *
     * @return 出队的元素
     */
    public T pop() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("空");
        }
//        if (!stack2.isEmpty()) {
//            return stack2.pop();
//        } else {
//            while (!stack1.isEmpty()) {
//                stack2.push(stack1.pop());
//            }
//        }
//        return stack2.pop();

        //优化：如果2为空，需要将1全部移到2中
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {

    }
}
