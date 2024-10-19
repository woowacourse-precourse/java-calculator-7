package calculator.domain;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Numbers {
    private final ArrayList<Number> numbers;

    public Numbers() {
        numbers = new ArrayList<>();
    }

    public void add(Number number) {
        if (number == null) {
            throw new IllegalArgumentException();
        }
        numbers.add(number);
    }

    public BigDecimal sum() {
        return numbers.stream()
                .map(Number::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
