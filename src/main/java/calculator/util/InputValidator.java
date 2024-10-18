package calculator.util;

import calculator.constants.Constants;
import java.util.regex.Matcher;

public class InputValidator {

    private static final int NUMBER_UNDER_BOUND = 47;
    private static final int NUMBER_OVER_BOUND = 58;

    public static void validateDelimiter(String input) {
        if (!containsComma(input) && !containsColon(input) && isLongerThanOne(input)) {
            throw new IllegalArgumentException(Constants.WRONG_DELIMITER);
        }
    }

    private static boolean containsComma(String input) {
        return input.contains(Constants.COMMA);
    }

    private static boolean containsColon(String input) {
        return input.contains(Constants.COMMA);
    }

    private static boolean isLongerThanOne(String input) {
        return input.length() > 1;
    }

    public static void validateCustomFormat(Matcher matcher) {
        if (!canFindRegex(matcher)) {
            throw new IllegalArgumentException(Constants.INVALID_CUSTOM_FORMAT);
        }
    }

    private static boolean canFindRegex(Matcher matcher) {
        return matcher.find();
    }

    public static void validateDefinedCustom(char letter, char asciiOfDelimiter) {
        if (!canBeNumber(letter) && isDifferentCharacter(letter, asciiOfDelimiter)) {
            throw new IllegalArgumentException(Constants.UNDEFINED_CUSTOM);
        }
    }

    private static boolean canBeNumber(char letter) {
        return letter > NUMBER_UNDER_BOUND && letter < NUMBER_OVER_BOUND;
    }

    private static boolean isDifferentCharacter(char letter, char asciiOfDelimiter) {
        return letter != asciiOfDelimiter;
    }

    public static void validateHasNumber(String string) {
        try {
            Long.valueOf(string);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(Constants.NOT_CONTAINS_NUMBER);
        }
    }

    public static void validatePositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(Constants.CONTAINS_NEGATIVE);
        }
    }
}
