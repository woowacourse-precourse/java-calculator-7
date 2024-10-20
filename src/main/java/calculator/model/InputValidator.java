package calculator.model;

import calculator.exception.ErrorCode;

public class InputValidator {

    public static void validate(String[] input) {
        for (int i = 0; i < input.length; i++) {
            String number = input[i];
            if (!number.isEmpty()) {
                // 문자열의 처음과 끝이 숫자인지 확인
                if (!Character.isDigit(number.charAt(0)) || !Character.isDigit(number.charAt(number.length() - 1))) {
                    throw new IllegalArgumentException(ErrorCode.INVALID_SEQUENCE.getMessage());
                }
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
