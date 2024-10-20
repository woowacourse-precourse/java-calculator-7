package calculator;

public class InputValidator {

    // 문자열이 올바른 정수인지 검증
    public static void validateNumber(String str) {
        try {
            int number = Integer.parseInt(str);
            // 음수일 경우 예외 발생
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
            }
        } catch (NumberFormatException e) {
            // 정수 형식이 아닐 경우 예외 발생
            throw new IllegalArgumentException("올바른 형식이 아닙니다: " + str);
        }
    }
}