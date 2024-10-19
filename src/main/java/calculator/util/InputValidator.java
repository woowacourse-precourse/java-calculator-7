package calculator.util;

import calculator.constants.InvalidInputConstants;
import java.util.regex.Matcher;

public class InputValidator {

    public static Long validateOnlyPlainNumber(String text) {
        try {
            return Long.valueOf(text);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InvalidInputConstants.WRONG_DELIMITER);
        }
    }

    public static void validateCustomFormat(Matcher matcher) {
        if (!canFindRegex(matcher)) {
            throw new IllegalArgumentException(InvalidInputConstants.INVALID_CUSTOM_FORMAT);
        }
    }

    private static boolean canFindRegex(Matcher matcher) {
        return matcher.find();
    }

    public static void validatePositive(Long number) {
        if (number < 0L) {
            throw new IllegalArgumentException(InvalidInputConstants.CONTAINS_NEGATIVE);
        }
    }

}
