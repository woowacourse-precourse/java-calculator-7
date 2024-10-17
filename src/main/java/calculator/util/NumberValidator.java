package calculator.util;

import calculator.enums.ErrorMessages;

public class NumberValidator {
    public static void isValidNumber(String numberString) {
        //TODO: 숫자 유효성 검증 유틸리티 메서드 구현
        try {
            int number = Integer.parseInt(numberString.trim());
            if (number < 0) {
                throw new IllegalArgumentException(ErrorMessages.NEGATIVE_NUMBER.getMessage() + number);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_FORMAT.getMessage() + numberString);
        }
    }
}
