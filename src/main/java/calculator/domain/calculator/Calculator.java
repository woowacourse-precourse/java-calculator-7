package calculator.domain.calculator;

import calculator.domain.collection.Delimiters;
import calculator.domain.collection.Numbers;
import calculator.error.ErrorMessage;

public class Calculator {
    private final Delimiters delimiters;
    private final Numbers numbers;

    private Calculator(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_INPUT);
        }

        input = removeWhitespace(input);

        this.delimiters = Delimiters.of(input);
        String processedInput = delimiters.removeDelimiterDefinition(input);
        String[] tokens = delimiters.split(processedInput);

        if (tokens.length == 0 || processedInput.isBlank()) {
            this.numbers = Numbers.empty();
        } else {
            this.numbers = Numbers.from(tokens);
        }
    }

    public static Calculator from(String input) {
        return new Calculator(input);
    }

    private String removeWhitespace(String input) {
        return input.replaceAll("\\s+", "");
    }

    public int sum() {
        return numbers.sum();
    }
}