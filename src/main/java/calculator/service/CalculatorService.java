package calculator.service;

import calculator.domain.Number;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CalculatorService {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.*)\\n.*$");
    private static final int CUSTOM_DELIMITER_INDEX = 2;
    private static final int CUSTOM_INPUT_START_INDEX = 4;
    private static final String NORMAL_DELIMITER = "[,:]";

    public Number add(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input cannot be null or blank");
        }
        List<Number> numbers = convertToNumbers(input);

        int sum = numbers.stream()
                         .mapToInt(Number::value)
                         .sum();

        return Number.from(sum);
    }

    private List<Number> convertToNumbers(final String input) {
        if (isCustomDelimiter(input)) {
            return splitCustom(input).stream()
                                     .map(this::parseInt)
                                     .map(Number::from)
                                     .toList();
        }
        return splitNormal(input).stream()
                                 .map(this::parseInt)
                                 .map(Number::from)
                                 .toList();
    }

    private boolean isCustomDelimiter(final String input) {
        return CUSTOM_DELIMITER_PATTERN.matcher(input)
                                       .matches();
    }

    private List<String> splitCustom(final String input) {
        String numberExpression = input.substring(CUSTOM_INPUT_START_INDEX);

        return Arrays.stream(
                             numberExpression.split(input.substring(CUSTOM_DELIMITER_INDEX, CUSTOM_DELIMITER_INDEX + 1)))
                     .toList();
    }

    private List<String> splitNormal(final String input) {
        return Arrays.stream(input.split(NORMAL_DELIMITER))
                     .toList();
    }

    private int parseInt(final String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Illegal Input input : " + input);
        }
    }
}
