package calculator.number.domain;


import calculator.number.util.NumberConvertor;
import calculator.separator.domain.Separator;

import java.util.List;

public class PositiveNumber implements Number {
    private final List<Long> numbers;
    private PositiveNumber(List<Long> numbers) {
        this.numbers = numbers;
    }
    public static PositiveNumber of(String extractValue, Separator separator) {
        List<Long> numbers = NumberConvertor.splitBySeparatorToList(extractValue, separator);
        return new PositiveNumber(numbers);
    }

    @Override
    public List<Long> getNumbers() {
        return numbers;
    }
}
