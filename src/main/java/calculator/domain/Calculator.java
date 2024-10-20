package calculator.domain;

import calculator.global.util.DelimiterExtractor;

import java.util.Arrays;

public class Calculator {

    private final DelimiterExtractor delimiterExtractor;

    public Calculator(DelimiterExtractor delimiterExtractor) {
        this.delimiterExtractor = delimiterExtractor;
    }

    public int calculate(String input) {
        return Arrays.stream(delimiterExtractor.extractNumber(input))
                .mapToInt(Integer::intValue)
                .sum();
    }
}
