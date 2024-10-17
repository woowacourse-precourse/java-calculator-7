package calculator.util;

import calculator.enums.ErrorMessages;

public class Validator {
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

    public static void validateCustomDelimiter(String input) {
        //TODO: 커스텀 구분자 검증 로직 구현
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\\n");

            if (newlineIndex == -1) {
                throw new IllegalArgumentException(ErrorMessages.MISSING_NEWLINE.getMessage());
            }

            String delimiter = input.substring(2, newlineIndex);

            if (delimiter.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessages.MISSING_CUSTOM_DELIMITER.getMessage());
            }
        }
    }
}
