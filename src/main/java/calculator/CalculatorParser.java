package calculator;

import calculator.exception.CalculatorParsedException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorParser {
    public static final String DEFAULT_DELIMITER = "[,:]";
    public static final Pattern CUSTOM_EMPTY_PATTERN = Pattern.compile("//\\\\n");
    public static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.+?)\\\\n.*");
    public static final Pattern EXPRESSION_PATTERN = Pattern.compile("-?\\d(.*)");
    public static final Pattern POSITIVE_INTEGER_PATTERN = Pattern.compile("^\\d+$");

    public static List<Integer> parse(String text) {
        text = text.replaceAll("\n", "\\\\n");
        String customDelimiter = extractCustomDelimiter(text);
        String expression = extractExpression(text);
        String regex = DEFAULT_DELIMITER + "|" + customDelimiter;

        if (expression == null) {
            throw new CalculatorParsedException(CalculatorParsedException.EMPTY_EXPRESSION);
        }
        return Arrays.stream(expression.split(regex))
                .map(CalculatorParser::toInteger).toList();
    }

    public static String extractCustomDelimiter(String text) {
        Matcher matcher = CUSTOM_PATTERN.matcher(text);

        if (!matcher.find()) {
            Matcher emptyMatcher = CUSTOM_EMPTY_PATTERN.matcher(text);
            if (emptyMatcher.find()) {
                throw new CalculatorParsedException(CalculatorParsedException.EMPTY_CUSTOM_DELIMITER);
            }

            return null;
        }

        String customDelimiter = matcher.group(1);

        if (Character.isDigit(customDelimiter.charAt(0))) {
            throw new CalculatorParsedException(CalculatorParsedException.CUSTOM_NOT_NUMERIC);
        }

        return Pattern.quote(customDelimiter);
    }

    private static String extractExpression(String text) {
        Matcher matcher = EXPRESSION_PATTERN.matcher(text);
        if (!matcher.find()) {
            return null;
        }

        return matcher.group(0);
    }

    private static int toInteger(String str) {
        Matcher matcher = POSITIVE_INTEGER_PATTERN.matcher(str);

        if (!matcher.matches()) {
            throw new CalculatorParsedException(CalculatorParsedException.POSITIVE_EXPRESSION);
        }

        return Integer.parseInt(str);
    }
}
