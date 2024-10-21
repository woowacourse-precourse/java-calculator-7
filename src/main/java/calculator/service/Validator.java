package calculator.service;

import java.util.Arrays;

public class Validator {

    private static final String ERROR_NOT_NUMBER = "올바르지 않은 숫자 형식입니다.";

    public void validate(String[] numbers) {
        Arrays.stream(numbers).forEach(this::validateNumber);
    }

    private void validateNumber(String input) {
        if (!isNumber(input)) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER);
        }
    }

    private boolean isNumber(String input) {
        return input.matches("\\d+");
    }
}
