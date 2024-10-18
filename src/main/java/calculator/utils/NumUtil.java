package calculator.utils;

public class NumUtil {

    private NumUtil() {}

    public static boolean isPositiveNum(String num) {
        return num.matches("^[0-9]*$"); // 양의 숫자
    }

    public static boolean startWithNum(String numStr) {
        return numStr.matches("^\\d.*|^$"); // 숫자로 시작 + 빈 문자열 허용
    }

    public static boolean endsWithNum(String numStr) {
        return numStr.matches(".*\\d|^$"); // 숫자로 끝 + 빈 문자열 허용
    }


    public static long toLong(String num) {
        if (isPositiveNum(num)) {
            return Long.parseLong(num);
        }
        throw new IllegalArgumentException("음수 혹은 문자가 포함되어 있습니다.");
    }
}
