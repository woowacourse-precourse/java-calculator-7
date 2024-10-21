package calculator.util;

import static calculator.common.ErrorMessage.*;

public class Validator {

    // 숫자 형식 및 음수 검증
    public static void validateNumber(String target) {
        try {
            int number = Integer.parseInt(target);
            if (number < 0) {
                throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR_MESSAGE + number);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_ERROR_MESSAGE + target);
        }
    }

    // 입력 문자열의 커스텀 구분자 형식 검증
    public static void validateCustomDelimiterFormat(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER_FORMAT_ERROR_MESSAGE);
            }
        }
    }

    // 커스텀 구분자 숫자가 아닌지 검증
    public static void validateCustomDelimiterIsNotNumber(String customDelimiter) {
        try {
            Integer.parseInt(customDelimiter);
            throw new IllegalArgumentException(CUSTOM_DELIMITER_CANNOT_BE_NUMBER_ERROR_MESSAGE);
        } catch (NumberFormatException ignored) {

        }
    }

}