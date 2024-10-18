package calculator;

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

        Arrays.stream(tokens).forEach(token -> {
            if (token.isEmpty()) {
                throw new IllegalArgumentException("연속된 구분자는 허용되지 않습니다.");
            }
        });

        List<String> parseList = List.of(tokens);
        if (parseList.contains("")) {
            throw new IllegalArgumentException("Invalid input: " + numbers);
        }
        return parseList;
    }
}
