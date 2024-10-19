package calculator;

import calculator.parser.StringParser;
import java.util.Arrays;

public class StringAdditionCalculator {
    private final StringParser parser;

    public StringAdditionCalculator(StringParser parser) {
        this.parser = parser;
    }

    public Long calculate(String input) {
        Long[] numbers = parser.parseToLong(input);
        return Arrays.stream(numbers)
                .reduce(0L, Long::sum);
    }
}
