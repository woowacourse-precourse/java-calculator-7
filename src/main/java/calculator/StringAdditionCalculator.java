package calculator;

import java.util.Arrays;

public class StringAdditionCalculator {
    private final CustomDelimiterParser parser;
    private final NumberValidator validator;

    public StringAdditionCalculator() {
        this.parser = new CustomDelimiterParser();
        this.validator = new NumberValidator();
    }

    public long calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 문자열이 null이거나 비어 있습니다.");
        }
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
