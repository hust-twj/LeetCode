package heap;

import java.util.PriorityQueue;

/**
 * 15. 数组中的第 K 个最大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/comments/
 * @author hust_twj
 * @date 2019/9/18
 */
public class FindKthLargest_215 {

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,1,5,6,4};
        System.out.print(findKthLargest(nums, 2));
    }

    /**
     * 找最大元素，用小顶堆
     */
    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        //最小堆，PriorityQueue 默认就是最小堆，依次加入元素到堆中，多于 k 个就删除根节点
        // 最后得到的就是最大的 k 个值，位于根节点的就是这个堆的最小值，也就是整个数组第 k 大的值
//        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });
        for (int i = 0; i <nums.length; i++) {
            queue.add(nums[i]);
            //超过k个数，移除堆顶元素
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
}
