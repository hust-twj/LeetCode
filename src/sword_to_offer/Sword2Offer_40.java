package sword_to_offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Description ：剑指offer 40 题：最小的K个数
 * top K问题
 * Created by Wenjing.Tang on 2020/3/29.
 */
public class Sword2Offer_40 {

    public static void main(String[] args) {

        int[] input = new int[]{3, 1, 2, 5, 7, 0, 10};
        minTopK(input, 3);
    }

    /**
     * 最小的K个数，top K， 最大堆
     */
    private static void minTopK(int[] inputArray, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
//        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
        for (int i = 0; i < inputArray.length; i++) {
            queue.add(inputArray[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
