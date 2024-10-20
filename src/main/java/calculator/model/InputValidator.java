package calculator.model;

import calculator.exception.ErrorCode;

public class InputValidator {

    public static void validate(String[] input) {
        for (int i = 0; i < input.length; i++) {
            String number = input[i];
            if (!number.isEmpty()) {
                try {
                    int value = Integer.parseInt(number);
                    if (value < 0) {
                        throw new IllegalArgumentException(ErrorCode.INVALID_NUMBER.getMessage());
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(ErrorCode.INVALID_VALUE.getMessage());
                }
            }
        }
    }
}
