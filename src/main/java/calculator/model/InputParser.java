package calculator.model;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    private final String delimiterRegex;
    private final String numbers;

    public InputParser(String delimiterRegex, String numbers) {
        this.delimiterRegex = delimiterRegex;
        this.numbers = numbers;
    }

    public List<String> parse() {
        if (numbers.isEmpty()) {
            return List.of();
        }

        String[] tokens = numbers.split(delimiterRegex, -1);
        validateTokens(tokens);

        return List.of(tokens);
    }

    private static void validateTokens(String[] tokens) {
        Arrays.stream(tokens).forEach(token -> {
            if (token.isEmpty()) {
                throw new IllegalArgumentException("연속된 구분자는 허용되지 않습니다.");
            }
        });
    }
}
