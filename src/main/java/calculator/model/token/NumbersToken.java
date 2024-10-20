package calculator.model.token;

import static calculator.model.token.ParsingPattern.NUMBER_SPLIT_LIMIT;

import calculator.model.Delimiter;
import calculator.model.Number;
import calculator.model.Numbers;
import java.util.Arrays;

public class NumbersToken {
    private final String token;

    public NumbersToken(String token) {
        this.token = token;
    }

    public String[] extractNumbers(Delimiter delimiter) {
        return token.split(delimiter.getDelimiter(), NUMBER_SPLIT_LIMIT.getNumber());
    }

    public Numbers convertToNumbers(Delimiter delimiter) {
        String[] extractNumbers = extractNumbers(delimiter);

        Numbers numbers = new Numbers();

        Arrays.stream(extractNumbers).map(Number::new).forEach(numbers::add);

        return numbers;
    }

    public boolean isEmpty() {
        return token.isEmpty();
    }

    @Override
    public String toString() {
        return token;
    }
}
