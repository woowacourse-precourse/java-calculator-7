package calculator.utils;

public class NumUtil {

    public static boolean isNum(char ch) {
        return '0' <= ch && ch <= '9';
    }

    public static boolean isValidFirstNum(String nums) {
        if (nums.isEmpty()) {
            return true; // 빈 문자열 허용
        }
        return isNum(nums.charAt(0));
    }

    public static int toInt(char ch) {
        if (isNum(ch)) {
            return ch - 48;
        }
        throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다.");
    }
}
