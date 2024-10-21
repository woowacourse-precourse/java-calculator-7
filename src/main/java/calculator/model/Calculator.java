package calculator.model;

import calculator.model.vo.Number;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<Number> numbers = new ArrayList<>();

    public Number calculate(String expression) {
        StringProcessor processor = new StringProcessor();
        numbers = processor.interpret(expression);
        return sum();
    }

    private Number sum() {
        return numbers.stream()
                .reduce(Number.of("0"), Number::add);
    }
}
