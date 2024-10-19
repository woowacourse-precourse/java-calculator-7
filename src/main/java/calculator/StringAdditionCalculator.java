package calculator;

import java.util.Arrays;

public class StringAdditionCalculator {
    private final CustomDelimiterParser parser;
    private final PositiveNumberValidator validator;

    public StringAdditionCalculator() {
        this.parser = new CustomDelimiterParser();
        this.validator = new PositiveNumberValidator();
    }

    public long calculate(String input) {
        String[] numbers = parser.parse(input);
        return calculateNumbers(numbers);
    }

    private long calculateNumbers(String[] numbers) {
        return Arrays.stream(numbers)
                .filter(s -> !s.isEmpty())
                .mapToLong(validator::validateAndParse)
                .sum();
    }
}
