package calculator.component;

import java.util.List;

public class Calculator {

    private final List<Integer> numbers;

    private Calculator(String expression) {
        numbers = new Parser(expression).parse();
    }

    public static Integer calculate(String expression) {
        if (expression.isBlank()) {
            return 0;
        }

        return new Calculator(expression).calculate();
    }

    private Integer calculate() {
        return numbers.stream()
                .reduce(0, Calculator::sum);
    }

    private static Integer sum(int a, int b) {
        if (a > Integer.MAX_VALUE - b) {
            throw new IllegalArgumentException();
        }
        return a + b;
    }
}
