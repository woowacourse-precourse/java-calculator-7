package calculator.domain;

import calculator.validator.CalculatorValidator;

public class Calculator {

    private final NumberStringExtractor numberStringExtractor;

    public Calculator(NumberStringExtractor numberStringExtractor) {
        this.numberStringExtractor = numberStringExtractor;
    }

    public int getSum(String stringToAdd) {
        if (stringToAdd.isBlank()) {
            return 0;
        }
        String[] stringsToNumber = numberStringExtractor.getStrings(stringToAdd);
        return sumNumbers(stringsToNumber);
    }

    private int sumNumbers(String[] stringToNumber) {
        int sum = 0;
        for (String str : stringToNumber) {
            CalculatorValidator.validatePositivity(str);
            sum += Integer.parseInt(str);
        }
        return sum;
    }
}
