package calculator;

import calculator.parser.StringParser;
import java.util.Arrays;

public class StringAdditionCalculator {
    private StringParser parser;

    public Long calculate(String input) {
        Long[] numbers = parser.parseToLong(input);
        return Arrays.stream(numbers)
                .reduce(0L, Long::sum);
    }

    public void setParser(StringParser parser) {
        this.parser = parser;
    }
}
