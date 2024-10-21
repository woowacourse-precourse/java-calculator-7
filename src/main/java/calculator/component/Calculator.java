package calculator.component;

import calculator.component.parser.ParserFactory;
import java.util.List;

public class Calculator {

    private final List<Integer> numbers;

    private Calculator(String expression) {
        numbers = ParserFactory.of(expression).parse();
    }

    public static Integer calculate(String expression) {
        return new Calculator(expression).calculate();
    }

    private Integer calculate() {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }
}
