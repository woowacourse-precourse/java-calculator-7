package calculator.validator;

import calculator.global.exception.ErrorMessage;

import static calculator.global.constant.DelimiterConstant.PREFIX;
import static calculator.global.constant.DelimiterConstant.SUFFIX;
import static calculator.global.constant.DelimiterConstant.DELIMITER_LIMIT_LENGTH;
import static calculator.global.constant.DelimiterConstant.VALID_NUMBER_REGEX;

public class DelimiterValidator {

    public static boolean hasCustomDelimiter(String str) {
        if (str.length() >= DELIMITER_LIMIT_LENGTH) {
            str = str.substring(0, str.lastIndexOf(SUFFIX)+SUFFIX.length());
            return str.startsWith(PREFIX) && str.endsWith(SUFFIX);
        }
        return false;
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
