package calculator.number.domain.impl;

import calculator.number.domain.NumberService;

import java.util.List;

public class DoubleNumber implements NumberService {
    private final List<Number> numbers;
    private DoubleNumber(List<Number> numbers) {
        this.numbers = numbers;
    }
    public static DoubleNumber of(List<Number> numberInfo) {
        return new DoubleNumber(numberInfo);
    }
    @Override
    public List<Number> getNumbers() {
        return numbers;
    }
}
