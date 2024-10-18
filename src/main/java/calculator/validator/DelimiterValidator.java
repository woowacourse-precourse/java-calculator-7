package calculator.validator;

import calculator.global.exception.ErrorMessage;

import static calculator.global.constant.DelimiterConstant.*;

public class DelimiterValidator {

    public static boolean hasCustomDelimiter(String str) {
        if (str.length() >= 5) {
            str = str.substring(0, str.lastIndexOf(SUFFIX)+2);

            return isCustomDelimiter(str);
        }

        return false;
    }

    private static boolean isCustomDelimiter(String str) {
        return str.startsWith(PREFIX) && str.endsWith(SUFFIX);
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

    public static void isDelimiterValid(String str, String delimiter) {
        if (!str.contains(delimiter)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ENROLLED_DELIMITER.getMessage());
        }
    }
}
