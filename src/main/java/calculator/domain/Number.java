package calculator.domain;

import calculator.constant.ExceptionMessage;

import java.util.regex.Pattern;

public class Number {

    private final int value;

    public Number(String value) {
        validateIsNumber(value);
        this.value = Integer.parseInt(value);
    }

    private void validateIsNumber(String value) {
        String NUMBER_REGEXP = "^\\d*$";
        if (!Pattern.matches(NUMBER_REGEXP, value)) {
            ExceptionMessage exceptionMessage = ExceptionMessage.NOT_INTEGER;
            throw new IllegalArgumentException(exceptionMessage.getMessage());
        }
    }

    public int getValue() {
        return value;
    }
}
