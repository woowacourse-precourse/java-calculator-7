package calculator.util;

public class ValidationUtil {
    public void isValidInput(String initialInput) {
        if (!initialInput.startsWith("//") && !Character.isDigit(initialInput.charAt(0))) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
    }

    public void isValidNumber(String s) {
        if (!Character.isDigit(s.charAt(0))) {
            throw new IllegalArgumentException("양수로 구성된 문자열을 입력해주세요.");
        }

    }

}
