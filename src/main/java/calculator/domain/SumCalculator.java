package calculator.domain;

import java.util.List;

public class SumCalculator implements Calculator {

    private final List<Double> positiveNumbers;

    public SumCalculator(List<Double> positiveNumbers) {
        this.positiveNumbers = positiveNumbers;
    }

    @Override
    public double calculate() {
        return positiveNumbers.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }
}