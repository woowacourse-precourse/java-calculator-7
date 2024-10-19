package calculator.domain;

import calculator.exception.NonPositiveNumberException;
import calculator.exception.StringInSplittedInputException;

public class Calculator {

    public int calculateSum(String[] numberStrings) {
        int sum = 0;
        for (String numberString : numberStrings) {
            sum += validateAndParseNumber(numberString);
        }
        return sum;
    }

    private int validateAndParseNumber(String numberString) {
        int number = validateNumericContent(numberString);
        validateNoNegativeNumber(number);
        return number;
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
