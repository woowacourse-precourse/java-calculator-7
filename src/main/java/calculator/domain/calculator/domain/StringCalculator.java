package calculator.domain.calculator.domain;

import static calculator.global.exception.ErrorMessage.INPUT_NULL;

import calculator.global.exception.ErrorMessage;

public class StringCalculator {
    private final String input;
    private final Delimiter delimiter;

    private StringCalculator(String input) {
        String stringCalculator = validateStringCalculator(input);
        this.input = extractCalculationInput(stringCalculator);
        this.delimiter = Delimiter.of(input);
    }

    public static StringCalculator of(
            final String input
    ) {
        return new StringCalculator(input);
    }

    private String validateStringCalculator(String input) {
        if (input.isBlank()) {
            return "0";
        }

        if (input == null) {
            throw new IllegalArgumentException(INPUT_NULL.getMessage());
        }

        return input;
    }

    private String extractCalculationInput(String input) {
        int lastIndex = input.indexOf("\\n");
        if (lastIndex != -1 && lastIndex < input.length() - 1) {
            String result = input.substring(lastIndex + 2);
            return result;
        }

        return input;
    }

    public String getInput() {
        return input;
    }

    public Delimiter getDelimiter() {
        return delimiter;
    }
}