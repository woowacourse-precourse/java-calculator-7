package calculator.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorService {

    private static final String POSITIVE_NUMBER_REGEX = "\\d+([.]\\d+)?";

    private final List<String> separators;

    public CalculatorService() {
        separators = SeparatorType.getDefaults();
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
        return new SeparatorSplitter(separators, expression).split();
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
        if (value.isEmpty() || !value.matches(POSITIVE_NUMBER_REGEX)) {
            throw new IllegalArgumentException("양수만 허용됩니다: " + value);
        }
    }

    private Number sum(Double[] values) {
        double result = Arrays.stream(values)
                .mapToDouble(Double::doubleValue)
                .sum();
        if (result % 1 == 0) {
            if (result > Long.MAX_VALUE) {
                throw new IllegalArgumentException("계산 결과가 너무 큽니다.");
            }
            return (long) result;
        }
        return result;
    }
}
