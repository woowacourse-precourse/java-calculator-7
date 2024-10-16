package calculator.domain;

import java.util.Arrays;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final int DEFAULT_SUM_RESULT = 0;
    private static final String CUSTOM_DELIMITER_START_SEPARATOR = "//";
    private static final String CUSTOM_DELIMITER_END_SEPARATOR = System.lineSeparator();
    private static final int INDEX_SHIFT = 1;
    private static final String DELIMITER_JOINER = "|";
    private static final String BLANK_STRING = "";
    public static final int BEGIN_INDEX = 2;
    public static final String INVALID_VALUE_ERROR_MESSAGE = "잘못된 값입니다.";

    public static int splitAndSum(final String str) {
        if (str == null || str.isEmpty()) {
            return DEFAULT_SUM_RESULT;
        }

        final String[] split = splitIncludeCustomDelimiter(str);

        return Arrays.stream(split).mapToInt(StringAddCalculator::parse).sum();
    }

    public static String[] splitIncludeCustomDelimiter(final String str) {
        return str.substring(str.indexOf(CUSTOM_DELIMITER_END_SEPARATOR) + INDEX_SHIFT).split(DEFAULT_DELIMITERS + checkCustomDelimiter(str));
    }

    public static String checkCustomDelimiter(final String str) {
        if (str.startsWith(CUSTOM_DELIMITER_START_SEPARATOR)) {
            return DELIMITER_JOINER + str.substring(BEGIN_INDEX, str.indexOf(CUSTOM_DELIMITER_END_SEPARATOR));
        }

        return BLANK_STRING;
    }

    private static int parse(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_VALUE_ERROR_MESSAGE);
        }
    }
}
