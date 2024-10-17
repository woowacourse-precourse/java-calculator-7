package calculator.parser;

import java.util.regex.Pattern;

public class StringParser {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELEMITER_PREFIX = "//";
    private static final String CUSTOM_DELEMITER_SUFFIX = "\n";

    public static ParseResult parse(String input) {
        if (input == null || input.isEmpty()) {
            return new ParseResult(null, null);
        }

        String delimiters = DEFAULT_DELIMITERS;
        String numberString = input;

        if (input.startsWith(CUSTOM_DELEMITER_PREFIX)) {
            int delimiterEnd = input.indexOf(CUSTOM_DELEMITER_SUFFIX);
            String customDelimiter = input.substring(CUSTOM_DELEMITER_PREFIX.length(), delimiterEnd);
            delimiters += "|" + customDelimiter;
            numberString = input.substring(CUSTOM_DELEMITER_SUFFIX.length() + delimiterEnd);
        }

        String[] numbers = numberString.split(delimiters);
        return new ParseResult(numbers, delimiters);
    }
}
