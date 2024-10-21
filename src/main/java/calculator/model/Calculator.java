package calculator.model;

import calculator.constant.CalculatorConstants;
import calculator.constant.ExceptionMessageConstants;
import java.util.List;

public class Calculator {
    private final List<Integer> numbers;

    public Calculator(List<String> numberStrings) {
        this.numbers = numberStrings.stream()
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .peek(this::validateNumber)
                .toList();
    }

    private void validateNumber(int num) {
        if (num < 0) {
            throw new IllegalArgumentException(
                    String.format(ExceptionMessageConstants.NEGATIVE_NOT_ALLOWED, num));
        }
        if (num > CalculatorConstants.MAX_NUMBER) {
            throw new IllegalArgumentException(
                    String.format(ExceptionMessageConstants.NUMBER_TOO_LARGE, CalculatorConstants.MAX_NUMBER));
        }
    }

    public int calculate() {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}