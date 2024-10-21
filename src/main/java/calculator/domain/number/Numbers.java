package calculator.domain.number;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    public Numbers() {
        this.numbers = new ArrayList<>();
    }

    public void addNumber(String letter) {
        Number number = new Number(letter);
        numbers.add(number);
    }

    public List<Integer> toInteger() {
        return numbers.stream()
                .map(Number::toInteger)
                .toList();
    }
}
