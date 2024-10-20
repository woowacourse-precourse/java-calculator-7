package calculator.util;

public class Validator {

    // 숫자 형식 및 음수 검증
    public static void validateNumber(String target) {
        try {
            int number = Integer.parseInt(target);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식입니다: " + target);
        }
    }

    // 입력 문자열의 커스텀 구분자 형식 검증
    public static void validateCustomDelimiterFormat(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 형식입니다. 커스텀 구분자는 //과 \\n 사이에 있어야 합니다.");
            }
        }
    }
}