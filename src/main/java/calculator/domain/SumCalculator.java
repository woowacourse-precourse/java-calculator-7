package calculator.domain;

import java.util.List;

public class SumCalculator implements Calculator {

    private final List<Integer> positiveIntegers;

    public SumCalculator(List<Integer> positiveIntegers) {
        this.positiveIntegers = positiveIntegers;
    }

    @Override
    public int calculate() {
        return positiveIntegers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}