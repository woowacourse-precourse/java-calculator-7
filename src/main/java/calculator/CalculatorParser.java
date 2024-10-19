package calculator;

import calculator.exception.CalculatorParsedException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorParser {
    public static final String DEFAULT_DELIMITER = ",:";
    public static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.*)(\n|\\\\n)(.*)");
    public static final Pattern POSITIVE_INTEGER_PATTERN = Pattern.compile("^\\d+$");

    public static List<Integer> parse(String text) {
        Result result = getResult(text);
        // 숫자로 변환
        String regex = "[" + result.delimiter() + "]";

        return Arrays.stream(result.text().split(regex))
                .map(CalculatorParser::toInteger)
                .toList();
    }

    private static Result getResult(String text) {
        String delimiter = DEFAULT_DELIMITER;
        Matcher matcher = CUSTOM_PATTERN.matcher(text);

        if (!matcher.find()) {
            return new Result(delimiter, text);
        }

        String customDelimiter = matcher.group(1);
        String parsedText = matcher.group(3);

        CustomDelimiterValidator.validate(customDelimiter);

        return new Result(delimiter + customDelimiter, parsedText);
    }

    private record Result(String delimiter, String text) {
    }

    private static int toInteger(String str) {
        Matcher matcher = POSITIVE_INTEGER_PATTERN.matcher(str);
        if (!matcher.find()) {
            throw new CalculatorParsedException(CalculatorParsedException.NOT_NUMERIC);
        }

        return Integer.parseInt(str);
    }
}
