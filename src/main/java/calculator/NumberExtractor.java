package calculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class NumberExtractor {

    private static final int START_TEXT_INDEX = 5;
    private static final int CUSTOM_DELIMITER_INDEX = 2;

    private final InputValidator validator = new InputValidator();

    public int defaultDelimiterExtractNumber(String input) {
        return Arrays.stream(input.split("[,:]"))
            .map(String::trim)
            .mapToInt(Integer::parseInt)
            .peek(validator::isNegativeNumber)
            .sum();
    }

    public int customDelimiterExtractNumber(String input) {
        String customDelimiter = Pattern.quote(extractCustomDelimiter(input));

        input = input.substring(START_TEXT_INDEX);
        String[] split = input.split("[,:" + customDelimiter + "]");

        return Arrays.stream(split)
            .map(String::trim)
            .mapToInt(Integer::parseInt)
            .peek(validator::isNegativeNumber)
            .sum();
    }

    private String extractCustomDelimiter(String input) {
        return String.valueOf(input.charAt(CUSTOM_DELIMITER_INDEX));
    }
}
