package calculator.validator;

import calculator.global.exception.ErrorMessage;

import static calculator.global.constant.DelimiterConstant.PREFIX;
import static calculator.global.constant.DelimiterConstant.SUFFIX;

public class DelimiterValidator {

    public static boolean hasCustomDelimiter(String str) {
        if (str.length() >= 5) {
            str = str.substring(str.indexOf(PREFIX), str.lastIndexOf(SUFFIX)+SUFFIX.length());
            return str.startsWith(PREFIX) && str.endsWith(SUFFIX);
        }
        return false;
    }

    public static String validateRequireEscapeCharacter(String customDelimiter) {
        if (customDelimiter.equals("|") || customDelimiter.equals(".")) {
            customDelimiter = "\\" + customDelimiter;
        }
        return customDelimiter;
    }

    public static void validateCustomDelimiterLength(String customDelimiter) {
        if (customDelimiter.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER_ERROR.getMessage());
        }
    }

    public static void validateIncludeDelimiter(String str) {
        if (!str.matches("-?\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ENROLLED_DELIMITER.getMessage());
        }
    }
}
