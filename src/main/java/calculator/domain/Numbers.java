package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private final List<Number> numbers = new ArrayList<>();

    public Numbers(String[] input) {
        for (String element : input) {
            numbers.add(new Number(element));
        }
    }

    public int add() {
        return numbers.stream()
                .mapToInt(Number::getValue)
                .sum();
    }
}
