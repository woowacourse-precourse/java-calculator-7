package calculator.util;

public class Validator {

    private static final String CUSTOM_DELIMITER_START_SEPARATOR = "//";

    public static boolean hasCustomDelimiter(final String input) {
        return input.startsWith(CUSTOM_DELIMITER_START_SEPARATOR);
    }
}
