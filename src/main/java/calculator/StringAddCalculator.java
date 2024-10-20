package calculator;

import java.util.Arrays;

public class StringAddCalculator {
    private static final String PATTERN = ",|:";

    public int calculate(String input) {
        return splitAndSumNumber(input);
    }

    public int splitAndSumNumber(String input) {
        return Arrays.stream(splitString(input)).mapToInt(Integer::parseInt).sum();
    }

    public String[] splitString(String input) {
        return input.split(PATTERN);
    }
}
