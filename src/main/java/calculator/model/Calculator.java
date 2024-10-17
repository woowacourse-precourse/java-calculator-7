package calculator.model;

import java.util.List;

public class Calculator {

    public int sum(List<Number> numbers) {
        return numbers.stream().mapToInt(Number::number).sum();
    }
}
