package calculator;

public class Validate {
    public static boolean isInteger(String str) {
        if (str == null || str.isEmpty()) {
            return false; // null이나 빈 문자열인 경우 false
        }

        // 정규 표현식을 사용하여 정수인지 확인
        return str.matches("-?\\d+");
    }
}
