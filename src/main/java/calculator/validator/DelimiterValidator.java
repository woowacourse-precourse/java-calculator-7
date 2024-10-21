package calculator.validator;

import calculator.global.exception.ErrorMessage;

import static calculator.global.constant.DelimiterConstant.*;

public class DelimiterValidator {

    public static boolean hasCustomDelimiter(String str) {
        return str.startsWith(PREFIX) && str.contains(SUFFIX);
    }

    public static void validateCustomDelimiterLength(String customDelimiter) {
        if (customDelimiter.length() > DELIMITER_LIMIT_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER_ERROR.getMessage());
        }
    }

    public static void validateIncludeDelimiter(String str) {
        if (!str.matches(VALID_NUMBER_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ENROLLED_DELIMITER.getMessage());
        }
    }
}