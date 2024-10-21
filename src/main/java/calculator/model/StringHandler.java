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
    private static final String NUMBER_REGEX = "\\d+";

    public int[] parseString(CalculationString calculationString) {
        String expressionString = calculationString.getString();
        ParsedExpressions parsedExpressions = extractDelimiterAndNumbers(expressionString);

        String numbersPart = parsedExpressions.numbersPart;
        String delimiter = parsedExpressions.delimiter;

        return convertToIntArray(numbersPart.split(delimiter));
    }

    private ParsedExpressions extractDelimiterAndNumbers(String expressionString) {
        if (expressionString.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            return parseCustomDelimiter(expressionString);
        }
        return new ParsedExpressions(DEFAULT_DELIMITERS, expressionString);
    }

    private ParsedExpressions parseCustomDelimiter(String expressionString) {
        Matcher customDelimiterMatcher = CUSTOM_DELIMITER_PATTERN.matcher(expressionString);
        validateCustomDelimiter(customDelimiterMatcher);

        String customDelimiter = customDelimiterMatcher.group(FIRST);
        String numbersPart = customDelimiterMatcher.group(SECOND);

        return new ParsedExpressions(customDelimiter, numbersPart);
    }

    private static void validateCustomDelimiter(Matcher customDelimiterMatcher) {
        if (isInvalidCustomDelimiterSyntax(customDelimiterMatcher)) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 문법입니다.");
        }
    }

    private static boolean isInvalidCustomDelimiterSyntax(Matcher customDelimiterMatcher) {
        return !customDelimiterMatcher.matches();
    }

    private int[] convertToIntArray(String[] stringArray) {
        return Arrays.stream(stringArray)
                .map(StringHandler::parseNumber)
                .peek(StringHandler::validateNegativeNumber)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static int parseNumber(String string) {
        validateNumber(string);
        return Integer.parseInt(string);
    }

    private static void validateNumber(String string) {
        if (isNotNumber(string)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private static boolean isNotNumber(String string) {
        return !string.matches(NUMBER_REGEX);
    }

    private static void validateNegativeNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
    }

    private record ParsedExpressions(String delimiter, String numbersPart) {
    }
}
