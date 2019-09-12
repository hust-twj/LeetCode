package binary_search;

/**
 * https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
 * Description ：744. 寻找比目标字母大的最小字母
 * Created by Wenjing.Tang on 2019-09-11.
 * <p>
 * 题目有点歧义，输入的数组有序，到底是自然有序还是循环有序？我倾向于前者。
 * 比如：
 * ['a', 'b', ... , 'z']为自然有序，最后一个字符一定大于前面的每一个字符；
 * ['z','a', 'b',...'z','a']为循环有序，'a'大于'z'
 */
public class NextGreatestLetter_744 {

    public static void main(String[] args) {
        char[] letters = new char[]{'c', 'f', 'j'};
        char target = 'j';
        System.out.println(nextGreatestLetter2(letters, target));
    }

    /**
     * 循环
     *
     * @param letters
     * @param target
     * @return
     */
    public static char nextGreatestLetter(char[] letters, char target) {
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > target) {
                return letters[i];
            }
        }
        return letters[0];
    }

    /**
     * 二分法
     *
     * @param letters
     * @param target
     * @return
     */
    public static char nextGreatestLetter2(char[] letters, char target) {
        if (letters.length == 0) {
            return ' ';
        }
        if (letters[letters.length - 1] <= target) {
            return letters[0];
        }
        int left = 0;
        int right = letters.length - 1;
        while (left < right) {
            int middle = (left + right) >>> 1;
            if (letters[middle] <= target) {
                left = middle + 1;
            }else {
                right = middle;
            }
        }
        return letters[left];
    }

}
