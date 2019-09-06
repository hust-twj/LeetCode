package two_points;

/**
 * 345. 反转字符串中的元音字母
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 * @author hust_twj
 * @date 2019/9/7
 */
public class ReverseVowels_345 {

    public static void main(String[] args) {
        String s1 = "hello";
        System.out.print(reverseVowels2(s1));
    }

    /**
     * 超过时间限制
     * @param s
     * @return
     */
    public static String reverseVowels(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return s;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (isVowels(s.charAt(left)) && isVowels(s.charAt(right))) {
                s = s.substring(0, left) + s.charAt(right) + s.substring(left + 1, right) +
                        s.charAt(left) + s.substring(right + 1, s.length());
                left++;
                right--;
            }else if (!isVowels(s.charAt(left))) {
                left++;
            }else if (!isVowels(s.charAt(right))) {
                right--;
            }
        }
        return s;
    }

    /**
     * StringBuilder操作String的替换
     * @param s
     * @return
     */
    public static String reverseVowels2(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder(s);
        int left = 0;
        int right = stringBuilder.length() - 1;
        while (left < right) {
            if (isVowels(stringBuilder.charAt(left)) && isVowels(stringBuilder.charAt(right))) {
                char leftChar = stringBuilder.charAt(left);
                char rightChar = stringBuilder.charAt(right);
                stringBuilder.replace(left, left+1, String.valueOf(rightChar));
                stringBuilder.replace(right, right+1, String.valueOf(leftChar));
                left++;
                right--;
            }else if (!isVowels(stringBuilder.charAt(left))) {
                left++;
            }else if (!isVowels(stringBuilder.charAt(right))) {
                right--;
            }
        }
        return stringBuilder.toString();
    }

    private static boolean isVowels(char c) {
        return c =='a' || c =='e' || c =='i' || c =='o' || c =='u' ||
                c =='A' || c =='E' || c =='I' || c =='O' || c =='U';
    }
}
