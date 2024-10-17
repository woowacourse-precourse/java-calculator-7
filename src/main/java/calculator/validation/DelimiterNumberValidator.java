package calculator.validation;

import calculator.exception.ErrorMessage;

import java.util.Arrays;

public class DelimiterNumberValidator {

    public int[] isValidNumber(String[] number) {
        return Arrays.stream(number)
                .mapToInt(this::parseNumber)
                .toArray();
    }

    private int parseNumber(String number) {
        if (isNumeric(number)) {
            return Integer.parseInt(number);
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
    }

    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

}