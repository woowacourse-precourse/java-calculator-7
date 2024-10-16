package calculator.domain;

import java.util.List;

public class StringCalculator implements Calculator {

    private final List<Double> numbers;

    public StringCalculator(List<Double> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Double calculate() {
        return numbers.stream()
                .map(this::checkPositive)
                .reduce(0d, Double::sum);
    }

    private Double checkPositive(Double number) {
        if (Double.compare(number, 0d) <= 0) {
            throw new IllegalArgumentException(String.format("%f : 양수가 아닙니다.", number));
        }
        return number;
    }
}
