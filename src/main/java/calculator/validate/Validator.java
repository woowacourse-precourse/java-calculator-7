package calculator.validate;

import java.util.regex.Matcher;

public class Validator {

    private static final String POSITIVE_INTEGER_PATTERN = "^(|[1-9][0-9]*)$";

    public static void validateNumber(String number) {
        if (!number.matches(POSITIVE_INTEGER_PATTERN)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateMatcher(Matcher matcher) {
        if (!matcher.find()) {
            throw new IllegalArgumentException();
        }
    }
}
