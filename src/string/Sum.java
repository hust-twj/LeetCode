package string;

/**
 * Description ：
 * 实现一个算法，来完成字符串相加，比如 "111" + ”2222“ = ”2333“。(高精度算法)
 * Created by Wenjing.Tang on 2020/4/29.
 */
public class Sum {
    public static void main(String[] args) {
        //  System.out.println(isNumber("+1"));

        System.out.println(addZero("hha", 4));
        try {
            String result = twoStringSum("123", "1111");
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String twoStringSum(String number1, String number2) throws Exception {
        if (number1 == null || number2 == null) {
            throw new Exception("Null Error");
        }
        if (!isNumber(number1) || !isNumber(number2)) {
            throw new Exception("Not number Error");
        }
        if (number1.length() == 0) {
            return number2;
        } else if (number2.length() == 0) {
            return number1;
        }

        //假设全部为整数
        int zeroCount = number1.length() > number2.length() ?
                number1.length() - number2.length() :
                number2.length() - number1.length();
        //短的数字字符串前面补0，使得两个字符串等长
        if (zeroCount > 0) {
            if (number1.length() > number2.length()) {
                number2 = addZero(number2, number1.length() - number2.length());
            } else {
                number1 = addZero(number1, number2.length() - number1.length());
            }
        }
        int carry = 0;//进位
        StringBuilder result = new StringBuilder();
        for (int i = number1.length() - 1; i >= 0; i--) {
            int current = Integer.parseInt(String.valueOf(number1.charAt(i))) +
                    Integer.parseInt(String.valueOf(number2.charAt(i)));
            result.append(carry + current % 10);
            carry = current / 10;
        }
        if (carry == 1) {
            result.append("1");
        }
        return result.reverse().toString();
    }

    /**
     * 在字符串numberString前面补 count 个 0
     *
     * @param numberString
     * @param count
     * @return
     */
    private static String addZero(String numberString, int count) {
        if (count <= 0) {
            return numberString;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append("0");
        }
        result.append(numberString);
        return result.toString();
    }


    // TODO: 2020/4/30 判断方法不好，大数的时候有问题

    /**
     * 是否为数字
     *
     * @param numberString
     * @return
     */
    private static boolean isNumber(String numberString) {
        boolean isNumber = true;
        try {
            Integer.parseInt(numberString);
        } catch (Exception e) {
            isNumber = false;
        }
        return isNumber;
    }
}

