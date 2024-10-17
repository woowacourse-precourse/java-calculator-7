package calculator.domain.calculator.domain;

import java.util.Arrays;

public class StringCalculator {
    private final String input;
    private final Delimiter delimiter;

    private StringCalculator(String input) {
        this.input = validateStringCalculator(input);
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
            throw new IllegalArgumentException("아무값도 입력하지 않을 순 없습니다.");
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