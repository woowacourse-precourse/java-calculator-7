package calculator.domain;

import calculator.exception.NonPositiveNumberException;
import calculator.exception.StringInSplittedInputException;

public class Calculator {

    public int calculateSum(String[] numberStrings) {
        int sum = 0;
        for (String numberString : numberStrings) {
            int number = validateNumericContent(numberString);
            validateNoNegativeNumber(number);
            sum += Integer.parseInt(numberString);
        }
        return sum;
    }

    private void validateNoNegativeNumber(int number) {
        if (number < 0) {
            throw new NonPositiveNumberException();
        }
    }

    private int validateNumericContent(String numberString) {
        try {
            return Integer.parseInt(numberString);
        } catch (IllegalArgumentException e) {
            throw new StringInSplittedInputException();
        }
    }
}
