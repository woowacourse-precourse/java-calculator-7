package calculator.validation;

import java.util.List;

public class InputValidator {
    private static final String ERROR_PREFIX = "[ERROR]";
    private static final String EMPTY_INPUT = "입력값이 없습니다.";
    private static final String NEGATIVE_NUMBER = "음수는 입력할 수 없습니다.";

    private String validateInput;
    private List<Integer> validateNumbers;

    public void inputValidate(String input) {
        validateInput = input;
        try {
            isEmpty();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public void numbersValidate(List<Integer> numbers) {
        validateNumbers = numbers;
        try {
            isNegative();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    private void isEmpty() {
        if (validateInput.isEmpty()) {
            throw new IllegalArgumentException(ERROR_PREFIX + EMPTY_INPUT);
        }
    }

    private void isNegative() {
        if (validateNumbers.stream().anyMatch(number -> number < 0)) {
            throw new IllegalArgumentException(ERROR_PREFIX + NEGATIVE_NUMBER);
        }
    }

}
