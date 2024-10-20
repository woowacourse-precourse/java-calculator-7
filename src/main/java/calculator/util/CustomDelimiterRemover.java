package calculator.util;

import calculator.enums.RegexPattern;

public class CustomDelimiterRemover {
    private static final String EMPTY_STRING = "";

    private CustomDelimiterRemover() {
    }

    public static String removeCustomDelimiters(String input) {
        return RegexPattern.CUSTOM_DELIMITER_DECLARATION.matcher(input).replaceAll(EMPTY_STRING);
    }
}
