package calculator.number.domain.impl;


import calculator.number.domain.Number;
import calculator.number.util.NumberConvertor;

import java.util.List;

public class PositiveNumber implements Number {
    private final List<Long> numbers;
    private PositiveNumber(List<Long> numbers) {
        this.numbers = numbers;
    }
    public static PositiveNumber of(List<String> numberInfo) {
        List<Long> numbers = NumberConvertor.stringListToLongList(numberInfo);
        return new PositiveNumber(numbers);
    }

    @Override
    public List<Long> getNumbers() {
        return numbers;
    }
}
