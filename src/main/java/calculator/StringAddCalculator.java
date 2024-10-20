package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static calculator.NumberUtils.sum;

public class StringAddCalculator {

    private static final int DEFAULT_VALUE = 0;
    public static final String CUSTOM_DELIMITER_PREFIX = "//";

    private final DelimiterHandler delimiterHandler = new DelimiterHandler();

    public int calculate(String input) {
        return Optional.ofNullable(input)
                .filter(it -> !it.isBlank())
                .map(this::processInput)
                .orElse(DEFAULT_VALUE);
    }

    private int processInput(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            return sumWithCustomDelimiter(input);
        } else {
            return sumWithDefaultDelimiter(input);
        }
    }

    private int sumWithCustomDelimiter(String input) {
        DelimiterAndNumber delimiterAndNumber = delimiterHandler.extractCustomDelimiterAndNumbers1(input);
        List<Integer> numbers = NumberUtils.splitNumbers(delimiterAndNumber);
        InputValidator.validateNumbers(numbers);
        return sum(numbers);
    }

    private int sumWithDefaultDelimiter(String input) {
        delimiterHandler.validateDefaultDelimiter(input);
        String[] splitNumbers = input.split(DefaultDelimiter.getAllDelimiters());

        List<Integer> numbers = Arrays.stream(splitNumbers)
                .map(Integer::parseInt)
                .toList();
        InputValidator.validateNumbers(numbers);
        return sum(numbers);
    }
}
