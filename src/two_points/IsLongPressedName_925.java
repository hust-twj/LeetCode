package two_points;

/**
 * 925. 长按键入
 * https://leetcode-cn.com/problems/long-pressed-name/
 * @author hust_twj
 * @date 2019/9/7
 */
public class IsLongPressedName_925 {

    public static void main(String[] args) {
        String s1 = "pyplrz";
        String s2 = "ppyypllr";
        System.out.print(isLongPressedName(s1, s2));
    }

    public static boolean isLongPressedName(String name, String typed) {
        if (name.isEmpty()) {
            return true;
        }
        if (typed.isEmpty()) {
            return false;
        }
        //注意：收尾相等
        if (name.charAt(0) != typed.charAt(0) ||
                name.charAt(name.length() - 1) != typed.charAt(typed.length() -1)) {
            return false;
        }
        int nameIndex = 1;
        int typedIndex = 1;
        while (nameIndex < name.length() && typedIndex < typed.length()) {
            if (name.charAt(nameIndex) == typed.charAt(typedIndex)) { //相等
                nameIndex++;
                typedIndex++;
            }else if (name.charAt(nameIndex) != typed.charAt(typedIndex) &&
                    typed.charAt(typedIndex - 1) == typed.charAt(typedIndex)) {
                //不等
                typedIndex++;
            }else {
                return false;
            }
        }
        return true;
    }
}
