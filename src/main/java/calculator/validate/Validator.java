package calculator.validate;

import java.util.regex.Matcher;

public class Validator {

    private static final String POSITIVE_NUMBER_PATTERN = "^(|[1-9][0-9]*)$";

    public static void validateNumber(String number) {
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
