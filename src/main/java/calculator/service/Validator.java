package calculator.service;

public class Validator {

    private static final String ERROR_NOT_NUMBER = "올바르지 않은 숫자 형식입니다.";

    public void validate(String[] numbers) {
        for (String num : numbers) {
            isNumber(num);
        }
    }

    private void isNumber(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER);
        }
    }
}
