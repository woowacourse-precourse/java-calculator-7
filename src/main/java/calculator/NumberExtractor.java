package calculator;

import java.util.Arrays;

public class NumberExtractor {

    private static final int START_TEXT_INDEX = 5;
    private static final int CUSTOM_DELIMITER_INDEX = 2;

    public int defaultDelimiterExtractNumber(String input) {
        return Arrays.stream(input.split("[,:]"))
            .map(String::trim)
            .mapToInt(Integer::parseInt)
            .sum();
    }

    public int customDelimiterExtractNumber(String input) {
        String customDelimiter = extractCustomDelimiter(input);

        input = input.substring(START_TEXT_INDEX);
        String[] split = input.split("[,:" + customDelimiter + "]");

        return Arrays.stream(split)
            .map(String::trim)
            .mapToInt(Integer::parseInt)
            .sum();
    }

    private String extractCustomDelimiter(String input) {
        return String.valueOf(input.charAt(CUSTOM_DELIMITER_INDEX));
    }
}
