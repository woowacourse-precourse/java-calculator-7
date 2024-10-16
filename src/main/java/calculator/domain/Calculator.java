package calculator.domain;

import calculator.validator.CalculatorValidator;

public class Calculator {

    private final CalculatorValidator validator;
    private final NumberStringExtractor numberStringExtractor;

    public Calculator(CalculatorValidator validator, NumberStringExtractor numberStringExtractor) {
        this.validator = validator;
        this.numberStringExtractor = numberStringExtractor;
    }

    public int getSum(String stringToAdd) {
        if (stringToAdd.isEmpty()) {
            return 0;
        }
        String[] stringsToNumber = numberStringExtractor.getStrings(stringToAdd);
        return sumNumbers(stringsToNumber);
    }

    private int sumNumbers(String[] stringToNumber) {
        int sum = 0;
        for (String str : stringToNumber) {
            validator.validatePositivity(str);
            sum += Integer.parseInt(str);
        }
        return sum;
    }
}
