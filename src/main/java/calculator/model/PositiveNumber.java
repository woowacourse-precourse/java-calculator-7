package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PositiveNumber {
    private final List<Long> positiveNumbers;

    private PositiveNumber(List<Long> positiveNumbers) {
        this.positiveNumbers = positiveNumbers;
    }

    public Long getPositiveNumberSum() {
        Long positiveNumberSum = 0L;
        for (Long number : positiveNumbers) {
            positiveNumberSum += number;
        }
        return positiveNumberSum;
    }

    public static PositiveNumber createPositiveNumber(String[] separatedPositiveNumbers) {
        return new PositiveNumber(changeStringToList(separatedPositiveNumbers));
    }

    private static List<Long> changeStringToList(String[] separatedPositiveNumbers) {
        return Arrays.stream(separatedPositiveNumbers)
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }
}
