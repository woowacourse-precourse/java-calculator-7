package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String DELIMITER = ",|;";
    private static final String REGEX = "//(.*?)\\\\n(.*)";

    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return calculateWithCustomDelimiter(matcher);
        }
        return calculateWithDefaultDelimiter(input);
    }

    private static int calculateWithCustomDelimiter(Matcher matcher) {
        String delimiter = matcher.group(1);
        String numbers = matcher.group(2);
        String[] values = numbers.split(Pattern.quote(delimiter));
        return Arrays.stream(values)
                .mapToInt(value -> toInt(value))
                .sum();
    }

    private static int calculateWithDefaultDelimiter(String input) {
        String[] values = input.split(DELIMITER);
        return Arrays.stream(values)
                .mapToInt(value -> toInt(value))
                .sum();
    }

    private static int toInt(String value) {
        try {
            int number = Integer.parseInt(value);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다." + value);
        }
    }
}
