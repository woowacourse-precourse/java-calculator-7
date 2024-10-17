package calculator.utils;

public class DelimiterUtils {

    private static final String SPACE = " ";

    private static final String EMPTY = "";

    private static final String SPECIAL_CHARACTERS_REGEX = "([.*+?^$(){}\\[\\]|\\\\])";

    private static final String SPECIAL_CHARACTERS_REPLACEMENT = "\\\\$1";

    private static final String UTILITY_CLASS = "Utility class";

    private DelimiterUtils() {
        throw new UnsupportedOperationException(UTILITY_CLASS);
    }

    public static String removeSpaces(String input) {
        return input.replace(SPACE, EMPTY);
    }

    public static String replaceSpecialCharacters(String input) {
        return input.replaceAll(SPECIAL_CHARACTERS_REGEX, SPECIAL_CHARACTERS_REPLACEMENT);
    }
}
