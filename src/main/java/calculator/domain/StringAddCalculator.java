package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class StringAddCalculator {
    private static final String DELIMITER = ",|:";
    private static final int DEFAULT_VALUE = 0;

    public StringAddCalculator() {
    }

    public int splitAndSum(final String inputValue) {
        if (inputValue.isBlank()) {
            return DEFAULT_VALUE;
        }
        return sum(splitToInteger(inputValue));
    }

    private List<Integer> splitToInteger(final String inputValue) {
        List<String> values = Arrays.asList(inputValue.split(DELIMITER));
        return values.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private int sum(final List<Integer> values) {
        return values.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
