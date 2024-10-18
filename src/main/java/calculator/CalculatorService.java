package calculator;

import java.util.Arrays;

public class CalculatorService {

    public char[] removeDelimiterAndToCharArray(String positiveString, String customDelimiter) {
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
        positiveString = positiveString.replaceAll("[:|,]", "");
        return positiveString.replace(customDelimiter, "");
    }
}