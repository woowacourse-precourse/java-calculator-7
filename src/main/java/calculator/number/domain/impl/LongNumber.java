package calculator.number.domain.impl;


import calculator.number.domain.NumberService;

import java.util.List;

public class LongNumber implements NumberService {
    private final List<Number> numbers;
    private LongNumber(List<Number> numbers) {
        this.numbers = numbers;
    }
    public static NumberService of(List<Number> numberInfo) {
        return new LongNumber(numberInfo);
    }

    @Override
    public List<Number> getNumbers() {
        return numbers;
    }
}
