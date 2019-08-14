package string;

/**
 * Description ：344. 反转字符串
 * https://leetcode-cn.com/problems/reverse-string/
 * Created by Wenjing.Tang on 2019-08-14.
 */

public class ReverseString_344 {
    public static void main(String[] args) {

    }

    public void reverseString(char[] s) {
        int i = 0, j =  s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }


}
