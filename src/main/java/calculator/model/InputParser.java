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

        String[] parsedNumbers = numbers.split(delimiterRegex, -1);
        validateTokens(parsedNumbers);

        return List.of(parsedNumbers);
    }

    private static void validateTokens(String[] parsedNumbers) {
        Arrays.stream(parsedNumbers).forEach(parsedNumber -> {
            if (parsedNumber.isEmpty()) {
                throw new IllegalArgumentException("연속된 구분자는 허용되지 않습니다.");
            }
        });
    }
}
