package calculator.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CalculatorService {

    private static final String CUSTOM_SEPARATOR_REGEX = "//(.*?)\\\\n";
    private static final String EMPTY = "";
    private static final String POSITIVE_NUMBER_REGEX = "\\d+([.]\\d+)?";

    private final List<String> separators;
    private String input;

    public CalculatorService(String input) {
        separators = SeparatorType.getDefaults();
        this.input = input;
    }

    public double calculate() {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 존재하지 않습니다.");
        }
        addCustomSeparatorIfPresent();
        String[] separatedValues = split();
        Double[] values = convertToNumbers(separatedValues);
        return sum(values);
    }

    private void addCustomSeparatorIfPresent() {
        Optional<String> customSeparator = new CustomSeparatorManager(input).extract();
        customSeparator.ifPresent(separators::add);
        this.input = input.replaceAll(CUSTOM_SEPARATOR_REGEX, EMPTY);
    }

    private String[] split() {
        return new SeparatorSplitter(separators, input).split();
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

    private double sum(Double[] values) {
        double result = Arrays.stream(values)
                .mapToDouble(Double::doubleValue)
                .sum();
        if (Double.isInfinite(result)) {
            throw new ArithmeticException("계산 결과가 너무 큽니다. 오버플로우 발생");
        }
        return result;
    }
}
