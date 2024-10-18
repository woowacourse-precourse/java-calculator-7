package calculator.service;

import java.util.Arrays;

public class CalculatorService {
    public static final String EMPTY = "";
    public static final String BASE_REGEX = "[:,]";

    public char[] toCharArrayWithoutDelimiter(String positiveString, String customDelimiter) {
        String positives = removeDelimiter(positiveString, customDelimiter);
        return positives.toCharArray();
    }

    public int[] convertCharArrayToIntArray(char[] positiveCharArray) {
        return new String(positiveCharArray)
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }

    public int calculatorNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .sum();
    }

    private String removeDelimiter(String positiveString, String customDelimiter) {
        positiveString = positiveString.replaceAll(BASE_REGEX, EMPTY);
        return positiveString.replace(customDelimiter, EMPTY);
    }
}