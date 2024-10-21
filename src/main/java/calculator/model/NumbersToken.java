package calculator.model;

import static calculator.model.enums.ParsingPattern.NUMBER_SPLIT_LIMIT;

import java.util.Arrays;

public class NumbersToken {
    private final String token;

    public NumbersToken(String token) {
        this.token = token;
    }

    public boolean isEmpty() {
        return token.isEmpty();
    }

    public Numbers convertToNumbers(Delimiter delimiter) {
        String[] extractNumbers = extractNumbers(delimiter);

        Numbers numbers = new Numbers();

        Arrays.stream(extractNumbers).map(Number::new).forEach(numbers::add);

        return numbers;
    }

    @Override
    public String toString() {
        return token;
    }

    private String[] extractNumbers(Delimiter delimiter) {
        return token.split(delimiter.getDelimiter(), NUMBER_SPLIT_LIMIT.getNumber());
    }
}
