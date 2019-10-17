package new_coder;

/**
 * 数值的整数次方
 * https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00?tpId=13&tqId=11165&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Description ：
 * Created by Wenjing.Tang on 2019-10-17.
 */
public class Power {

    public static void main(String[] args) {

        System.out.println(Power(2, -3));
    }

    public static double Power(double base, int exponent) {
        double result = 1;
        if (exponent == 0) {
            return 1;
        }else if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                result *= base;
            }
            return result;
        }else {
            for (int i = 0; i < -exponent; i++) {
                result *= base;
            }
            return 1d/ result;
        }
    }

}
