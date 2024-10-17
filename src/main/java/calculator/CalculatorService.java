package calculator;

import java.util.Arrays;

public class CalculatorService {
    private final NumberValidator numberValidator;

    public CalculatorService() {
        this.numberValidator = new NumberValidator();
    }

    public char[] removeDelimiterAndToCharArray(String positiveString, String customDelimiter) {
        String positives = removeDelimiter(positiveString, customDelimiter);
        return positives.toCharArray();
    }

    private String removeDelimiter(String positiveString, String customDelimiter) {
        positiveString = positiveString.replaceAll("[:|,]", "");
        return positiveString.replace(customDelimiter, "");
    }

    public int[] convertCharArrayToIntArray(char[] positiveCharArray) {
        numberValidator.validateNoDigits(positiveCharArray);

        return new String(positiveCharArray)
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }

    public int calculatorNumbers(int[] numbers) {
        numberValidator.validatorNoNegatives(numbers);

        return Arrays.stream(numbers)
                .sum();
    }
}