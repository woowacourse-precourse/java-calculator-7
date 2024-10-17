package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    public Numbers() {
        numbers = new ArrayList<>();
    }

    public void add(String numberStr) {
        numbers.add(new Number(numberStr));
    }
}
