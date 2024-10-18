package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private List<Number> numbers;

    public Numbers() {
        this.numbers = new ArrayList<>();
    }

    public void add(Number number) {
        numbers.add(number);
    }
}
