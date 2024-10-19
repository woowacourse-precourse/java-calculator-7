package calculator;

import calculator.exception.CalculatorParsedException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorParser {
    public static final String DEFAULT_DELIMITER = ",:";
    public static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.*)(\n|\\\\n)(.*)");

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

        if (customDelimiter.isEmpty()) {
            throw new CalculatorParsedException("커스텀 구분자로 빈 값이 올 수 없습니다.");
        }
        if (customDelimiter.length() >= 2) {
            throw new CalculatorParsedException("커스텀 구분자로 2자 이상이 올 수 없습니다.");
        }
        if (Character.isDigit(customDelimiter.charAt(0))) {
            throw new CalculatorParsedException("커스텀 구분자로 숫자가 올 수 없습니다.");
        }

        return new Result(delimiter + customDelimiter, parsedText);
    }

    private record Result(String delimiter, String text) {
    }

    private static int toInteger(String str) {
        int i = Integer.parseInt(str);

        if (i < 0) {
            throw new CalculatorParsedException("정수만 입력할 수 있습니다.");
        }

        return i;
    }
}
