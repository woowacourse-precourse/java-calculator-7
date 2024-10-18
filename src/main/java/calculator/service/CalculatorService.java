package calculator.service;

import calculator.util.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorService {

    private final Separators separators;

    public CalculatorService() {
        separators = Separators.init();
    }

    public Number calculate(String input) {
        Command command = new Command(input);
        if (command.hasCustomSeparator()) {
            separators.add(command.getCustomSeparator());
        }
        String expression = command.getExpression();
        String[] separatedValues = split(expression);
        Double[] values = convertToNumbers(separatedValues);
        return sum(values);
    }

    private String[] split(String expression) {
        return new SeparatorSplitter(separators.getValues(), expression).split();
    }

    private Double[] convertToNumbers(String[] separatedValues) {
        List<Double> numbers = new ArrayList<>();
        for (String value : separatedValues) {
            validatePositiveNumber(value);
            numbers.add(Double.parseDouble(value));
        }
        return numbers.toArray(new Double[0]);
    }

    private void validatePositiveNumber(String value) {
        if (value.isEmpty() || !value.matches(Constants.POSITIVE_NUMBER_REGEX)) {
            throw new IllegalArgumentException("양수만 허용됩니다.");
        }
    }

    private Number sum(Double[] values) {
        double result = getSum(values);
        if (isWholeNumber(result)) {
            checkLongRange(result);
            return (long) result;
        }
        checkDoubleRange(result);
        return result;
    }

    private double getSum(Double[] values) {
        return Arrays.stream(values)
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    private boolean isWholeNumber(double result) {
        return result % 1 == 0;
    }

    private void checkLongRange(double result) {
        if (result > Long.MAX_VALUE) {
            throw new IllegalArgumentException("계산 결과가 너무 큽니다.");
        }
    }

    private void checkDoubleRange(double result) {
        if (result > Double.MAX_VALUE) {
            throw new IllegalArgumentException("계산 결과가 너무 큽니다.");
        }
    }
}
