package calculator;

import java.util.List;

public class NumberValidator {
    public void validate(List<String> splitNumber) {
        for (String candidate : splitNumber) {
            validateParseNumber(candidate);
            validatePositiveNumber(candidate);
        }
    }

    private void validateParseNumber(String number) {
        if (number.isBlank()) {
            return;
        }

        try {
            Double.parseDouble(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private void validatePositiveNumber(String number) {
        if (number.isBlank()) {
            return;
        }

        if (Double.parseDouble(number) < 0) {
            throw new IllegalArgumentException("양수를 입력해주세요.");
        }
    }
}
