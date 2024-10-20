package calculator.domain;

import static calculator.exception.Exception.INVALID_NEGATIVE_NUMBER;
import static calculator.exception.Exception.INVALID_NUMBER_FORMAT;

import java.util.List;

public class InputValidator {
    public void validate(List<String> stringInputs) {
        for (String s : stringInputs) {
            validateNumberFormat(s);
            validatePositiveNumber(s);
        }
    }

    // 문자열 : 정수인지 확인
    private void validateNumberFormat(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage() + s);
        }
    }

    // 문자열 : 양수인지 확인
    private void validatePositiveNumber(String s) {
        int value = Integer.parseInt(s);
        if (value < 0) {
            throw new IllegalArgumentException(INVALID_NEGATIVE_NUMBER.getMessage() + s);
        }
    }
}
