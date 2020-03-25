package sort;

import java.util.Arrays;

/**
 * Description ：归并排序
 * 最好、最坏时间复杂度：O(nlgn)；空间复杂度：O(n)
 * Created by Wenjing.Tang on 2019-09-16.
 * <p>
 * 参考：
 * https://blog.csdn.net/MoreWindows/article/details/6678165
 * https://www.cnblogs.com/chengxiao/p/6194356.html
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] array) {
        //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            //（归并 之 递“归”的过程）
            sort(arr, left, mid);//左边归并排序，使得左子序列有序
            sort(arr, mid + 1, right);//右边归并排序，使得右子序列有序
            //合并
            merge(arr, left, mid, right);//将两个有序子数组合并操作
        }
    }

    /**
     * 数组合并（归并 之 合“并”的过程）
     * @param arr 数组
     * @param left left
     * @param mid  mid
     * @param right right
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        // 定义一个辅助数组，所以该算法的空间复杂度为O（n）
        int[] temp = new int[right - left + 1];
        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        int t = 0;//临时数组指针

        // 找出较小值元素放入temp数组中
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        //如果i
        while (i <= mid) {//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while (j <= right) {//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

}
