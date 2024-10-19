package calculator;

import java.util.Arrays;

public class StringCalculator {

    private final Parser parser;
    private final InputValidator inputValidator;

    public StringCalculator(Parser parser, InputValidator inputValidator) {
        this.parser = parser;
        this.inputValidator = inputValidator;
    }

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = parser.parseNumbers(input);
        inputValidator.validate(numbers);

        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}