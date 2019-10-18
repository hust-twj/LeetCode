package new_coder;

import java.util.*;

/**
 * 最小的 K 个数
 * https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=13&tqId=11182&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Description ：
 * Created by Wenjing.Tang on 2019-10-18.
 */
public class GetLeastNumbers_Solution {

    public static void main(String[] args) {
        int[] input = new int[]{4,5,1,6,2,7,3,8};
        ArrayList<Integer> result = GetLeastNumbers_Solution3(input, 3);

        for (Integer integer : result) {
            System.out.print(integer + "  ");
        }

    }

    /**
     * 方法1：先对数组进行排序
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (k > input.length || k == 0) {
            return result;
        }
        Arrays.sort(input);

        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    /**
     * 方法2：top K 问题的变形：堆
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (k > input.length || k == 0) {
            return result;
        }
        //最小堆 大小为input.length
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < input.length; i++) {
            queue.add(input[i]);
        }

        while (k>0) {
            result.add(queue.poll());
            k--;
        }
        return result;
    }

    /**
     * 最大堆 大小为K
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution3(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (k > input.length || k == 0) {
            return result;
        }
        //最大堆
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        //构建大小为K的最大堆
        for (int i = 0; i < input.length; i++) {
            //堆大小没有满
            if (maxheap.size() < k) {
                maxheap.offer(input[i]);
            }else {
                //说明堆顶不是最小元素，需要删除
              if (maxheap.peek() > input[i]) {
                  maxheap.poll();
                  maxheap.offer(input[i]);
              }
            }
        }

        //从大到小依次加入元素到堆
        while (!maxheap.isEmpty()) {
            result.add(maxheap.poll());
        }
        //从小到大排序
        Collections.reverse(result);
        return result;
    }

}
