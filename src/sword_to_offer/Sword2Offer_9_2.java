package sword_to_offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description ：剑指offer 第 9 题：用两个队列实现栈
 * Created by Wenjing.Tang on 2020/3/28.
 */
public class Sword2Offer_9_2<T> {

    private Deque<T> queue1 = new LinkedList<>();
    private Deque<T> queue2 = new LinkedList<>();

    /**
     * 入栈
     *
     * @param t 入栈的元素
     */
    public void push(T t) {
        queue1.push(t);
    }

    /**
     * 出栈
     *
     * @return 出栈的元素
     */
    public T pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            throw new RuntimeException("空");
        }
        if (queue2.isEmpty()) {
            while (!queue1.isEmpty()) {
                queue2.push(queue1.pop());
            }
        }
        return queue2.pop();
    }

    public static void main(String[] args) {

    }
}
