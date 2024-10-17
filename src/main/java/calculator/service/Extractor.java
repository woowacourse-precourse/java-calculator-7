package calculator.service;

import java.util.Arrays;
import java.util.List;

public class Extractor {

    private static final String NUMERIC_REGEX = "[0-9]+";

    public List<Integer> extractNumbers(String input, String delimiter) {
        String[] extractNumberString = input.split(delimiter);
        return Arrays.stream(extractNumberString)
            .filter(this::isPositiveNumber)
            .map(Integer::parseInt)
            .toList();
    }

    public String extractNumberPart(String input, boolean isCustomDelimiter) {
        if (isCustomDelimiter) {
            input = input.split("\\\\n")[1];
        }
        return input;
    }

    private boolean isPositiveNumber(String s) {
        if (s.matches(NUMERIC_REGEX)) {
            return true;
        }
        throw new IllegalArgumentException("양수와 구분자만 입력 가능합니다.");
    }
}
