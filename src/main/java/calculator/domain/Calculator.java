package calculator.domain;

import calculator.exception.NonPositiveNumberException;
import calculator.exception.StringInSplittedInputException;

public class Calculator {

    public int calculateSum(String[] numberStrings) {
        if (isStringZero(numberStrings)) {
            return 0;
        }
        int sum = 0;
        for (String numberString : numberStrings) {
            sum += validateAndParseNumber(numberString);
        }
        return sum;
    }

    private boolean isStringZero(String[] numberStrings) {
        return numberStrings.length == 1 && "0".equals(numberStrings[0]);
    }

    private int validateAndParseNumber(String numberString) {
        int number = validateNumericContent(numberString);
        validatePositiveNumber(number);
        return number;
    }
    
    private void validatePositiveNumber(int number) {
        if (number <= 0) {
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
