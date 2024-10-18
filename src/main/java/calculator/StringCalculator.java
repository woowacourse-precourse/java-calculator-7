package calculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String EMPTY_INPUT_USING_CUSTOM_DELIMITER = "^//.\\\\n$";
    private final DelimiterParser delimiterParser;

    public StringCalculator(DelimiterParser delimiterParser) {
        this.delimiterParser = delimiterParser;
    }

    public int add(String input) {
        if (input.isEmpty() || Pattern.matches(EMPTY_INPUT_USING_CUSTOM_DELIMITER, input)) {
            return 0;
        }

        return calculateSum(input);
    }

    public int calculateSum(String input) {
        return Arrays.stream(delimiterParser.parse(input))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
