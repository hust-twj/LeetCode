package new_coder;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 数组中出现次数超过一半的数字
 * https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?tpId=13&tqId=11181&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Description ：
 * Created by Wenjing.Tang on 2019-10-17.
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为 9 的数组 {1,2,3,2,2,2,5,4,2}。由于数字 2 在数组中出现了 5 次，超过数组长度的一半，因此输出 2。如果不存在则输出 0。
 */
public class MoreThanHalfNum_Solution {

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(array));

    }

    /**
     * 方法1：散列表
     * @param array
     * @return
     */
    public static int MoreThanHalfNum_Solution(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            }else {
                map.put(array[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > array.length / 2) {
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
     * 方法2：散列表（优化）
     * @param array
     * @return
     */
    public static int MoreThanHalfNum_Solution2(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
                //此处可以获得数组的个数
                if (map.get(array[i]) > array.length / 2) {
                    return array[i];
                }
            }else {
                map.put(array[i], 1);
            }
        }
        return 0;
    }
}
