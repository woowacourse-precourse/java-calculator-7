package calculator.model;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHandler {

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String DEFAULT_DELIMITERS = "[,:]";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\\\\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);
    private static final int FIRST = 1;
    private static final int SECOND = 2;

    public int[] parseString(CalculationString calculationString) {
        String expressionString = calculationString.getString();
        if (expressionString.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            return parseCustomDelimiter(expressionString);
        }
        return parseDefaultDelimiter(expressionString);
    }

    private int[] parseCustomDelimiter(String expressionString) {
        Matcher customDelimiterMatcher = CUSTOM_DELIMITER_PATTERN.matcher(expressionString);
        if (customDelimiterMatcher.matches()) {
            String customDelimiter = customDelimiterMatcher.group(FIRST);
            String numbersPart = customDelimiterMatcher.group(SECOND);
            return convertToIntArray(numbersPart.split(customDelimiter));
        }
        throw new IllegalArgumentException("잘못된 구분자 문법입니다.");
    }

    private int[] parseDefaultDelimiter(String expressionString) {
        return convertToIntArray(expressionString.split(DEFAULT_DELIMITERS));
    }

    private void validateNegativeNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
    }

    private int[] convertToIntArray(String[] stringArray) {
        return Arrays.stream(stringArray)
                .map(Integer::parseInt)
                .peek(this::validateNegativeNumber)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
