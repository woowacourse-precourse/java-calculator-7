package calculator.domain;

import calculator.constants.Constants;
import java.util.regex.Matcher;

public class UserInputValidator {

    private static final int ONE = 1;
    private static final int NUMBER_UNDER_BOUND = 47;
    private static final int NUMBER_OVER_BOUND = 58;

    public static void wrongDelimiter(String input) {
        if (!input.contains(Constants.COMMA) && !input.contains(Constants.COLON) && input.length() > ONE) {
            throw new IllegalArgumentException(Constants.WRONG_DELIMITER);
        }
    }

    public static void checkNotExistCustom(Matcher matcher) {
        if (!canFindRegex(matcher)) {
            throw new IllegalArgumentException(Constants.NOT_EXIST_CUSTOM);
        }
    }

    private static boolean canFindRegex(Matcher matcher) {
        return matcher.find();
    }

    public static void checkNotDefinedCustom(char letter, char asciiOfDelimiter) {
        if (!canBeNumber(letter) && isDifferentCharacter(letter, asciiOfDelimiter)) {
            throw new IllegalArgumentException(Constants.NOT_DEFINED_CUSTOM);
        }
    }

    private static boolean canBeNumber(char letter) {
        return letter > NUMBER_UNDER_BOUND && letter < NUMBER_OVER_BOUND;
    }

    private static boolean isDifferentCharacter(char letter, char asciiOfDelimiter) {
        return letter != asciiOfDelimiter;
    }

    public static void checkNotContainsNumber(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(Constants.NOT_CONTAINS_NUMBER);
        }
    }

    public static void checkNumberNegative(int number) {
        if (number < Constants.ZERO) {
            throw new IllegalArgumentException(Constants.CONTAINS_NEGATIVE);
        }
    }
}
