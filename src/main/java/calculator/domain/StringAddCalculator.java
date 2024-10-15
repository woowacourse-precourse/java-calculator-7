package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringAddCalculator {
    private static final String DELIMITER = ",|:";

    public StringAddCalculator() {
    }

    public int splitAndSum(final String inputValue) {
        List<Integer> values = splitToInteger(inputValue);
        return sum(values);
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
