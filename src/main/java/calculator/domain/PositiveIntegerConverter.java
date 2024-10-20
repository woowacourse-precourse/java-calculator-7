package calculator.domain;

import calculator.global.exception.CalculatorException;
import calculator.global.message.ErrorMessage;
import java.util.List;

public class PositiveIntegerConverter {

    private final List<String> splittedExpression;

    public PositiveIntegerConverter(List<String> splittedExpression) {
        validatePositiveIntegers(splittedExpression);
        this.splittedExpression = splittedExpression;
    }

    public List<Integer> convertToPositiveIntegers() {
        return splittedExpression.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private void validatePositiveIntegers(List<String> splittedExpression) {
        for (String numberString : splittedExpression) {
            validatePositiveInteger(numberString);
        }
    }

    private void validatePositiveInteger(String numberString) {
        try {
            int number = Integer.parseInt(numberString);
            if (number < 0) {
                throw CalculatorException.from(ErrorMessage.NEGATIVE_NUMBER_NOT_ALLOWED);
            }
        } catch (NumberFormatException e) {
            throw CalculatorException.from(ErrorMessage.INVALID_NUMBER_FORMAT);
        }
    }
}