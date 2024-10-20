package calculator.domain;

import java.util.List;

public class Calculator {

    private static final Calculator instance = new Calculator();

    private Calculator() { }

    public static Calculator getInstance() {
        return instance;
    }

    public Number calculate(Operation operation, List<Number> numbers) {
        return numbers
            .stream()
            .reduce(operation::execute)
            .orElseThrow(() -> new IllegalArgumentException("피연산자는 1개 이상이어야합니다."));
    }

}
