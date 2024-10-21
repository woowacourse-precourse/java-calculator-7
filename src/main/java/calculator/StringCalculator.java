package calculator;

import java.util.stream.Stream;

public class StringCalculator {
    private final InputValidator validator;

    public StringCalculator() {
        this.validator = new InputValidator();
    }

    private String normalizeDelimiter(String input) {
        String[] split = input.split("\\\\n");

        String delimiter = split[0].replace("//", "");
        String numbers = split[1];

        input = numbers.replace(delimiter, ",");
        return input;
    }

    public int calculate(String input) {

        if (input.isEmpty()) {
            return 0;
        }

        if (input.startsWith("//")) {
            input = normalizeDelimiter(input);
        }

        validator.validate(input);
        String[] numbers = input.split(",|:");

        return Stream.of(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}

