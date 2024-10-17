package calculator.validator;

public class InputValidator {


    public void validateEmptyOrNull(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다. 빈 문자열 또는 null 입력은 허용되지 않습니다.");
        }
    }

    public void checkNegativeNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
        }
    }
}
