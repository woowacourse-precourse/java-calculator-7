package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DelimeterParser {

    private static final String DEFAULT_DELIMITERS = "[,|:]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//.*\n";

    public static String[] parse(String input) {
        String delimiters = getDelimiter(input);
        String numbers = removeCustomDelimiterPrefix(input);
        return numbers.split(delimiters);
    }

    private static String getDelimiter(String input) {
        boolean hasCustomDelimiter = input.startsWith("//");

        if (hasCustomDelimiter) {
            int delimiterEndIndex = input.indexOf("\n");
            return Pattern.quote(input.substring(2, delimiterEndIndex));
        }

        return DEFAULT_DELIMITERS;
    }

    private static String removeCustomDelimiterPrefix(String input) {
        return input.replaceFirst(CUSTOM_DELIMITER_PREFIX, "");
    }
}
