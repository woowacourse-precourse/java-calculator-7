package calculator.domain;

import java.util.List;

public class PositiveNumbers {

    private final List<PositiveNumber> numbers;

    public PositiveNumbers(List<String> invalidNumbers) {
        this.numbers = invalidNumbers
                .stream()
                .map(PositiveNumber::new)
                .toList();
    }

    public int calculateSum() {
        return numbers.stream()
                .mapToInt(PositiveNumber::getNumber)
                .sum();
    }
}
