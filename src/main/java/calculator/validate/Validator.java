package calculator.validate;

import static calculator.constants.Regex.POSITIVE_NUMBER_PATTERN;

import java.util.regex.Matcher;

public class Validator {

    public static void validateNumber(String number) {
        if (number.isEmpty()) {
            return;
        }
        validatePositiveNumber(number);
    }

    private static void validatePositiveNumber(String number) {
        if (!number.matches(POSITIVE_NUMBER_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER);
        }
    }

    public static void validateMatcher(Matcher matcher) {
        if (!matcher.find()) {
            throw new IllegalArgumentException(ErrorMessage.MATCHER_NOT_FOUND);
        }
    }
}
