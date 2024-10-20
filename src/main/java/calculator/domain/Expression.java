package calculator.domain;

import static calculator.error.ErrorType.INPUT_FORMAT_ERROR;
import static calculator.error.ErrorType.INPUT_NEGATIVE_NUMBER_ERROR;

import java.util.Arrays;
import java.util.List;

public class Expression {
    private final List<Integer> numbers;
    private final int result;

    public Expression(final String[] input) {
        this.numbers = convertToIntegers(input);
        validate();
        this.result = calculate();
    }

    private void validate() {
        numbers.forEach(number -> {
            if (number < 0) {
                throw new IllegalArgumentException(INPUT_NEGATIVE_NUMBER_ERROR.getMessage());
            }
        });

    }

    private List<Integer> convertToIntegers(final String[] strings) {
        try {
            return Arrays.stream(strings)
                    .map(s -> (s == null || s.trim().isEmpty()) ? 0 : Integer.parseInt(s.trim()))
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_FORMAT_ERROR.getMessage());
        }
    }

    private int calculate() {
        return numbers.stream().reduce(0, Integer::sum);
    }

    public int getResult() {
        return result;
    }
}
