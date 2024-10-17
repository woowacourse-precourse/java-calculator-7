package calculator;

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

    public int[] convertCharArrayToIntArray(char[] positiveCharArray) { // todo : 리팩토링
        numberValidator.validateNoDigits(positiveCharArray);

        return new String(positiveCharArray)
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }

    public int calculatorNumbers(int[] numbers) {
        int total = 0;

        numberValidator.validatorNoNegatives(numbers);
        for (int number : numbers)
            total += number;

        return total;
    }
}