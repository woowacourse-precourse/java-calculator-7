package calculator.domain;

import java.util.Arrays;

public class Calculator {

    private static final Calculator instance = new Calculator();

    private Calculator() { }

    public static Calculator getInstance() {
        return instance;
    }

    Number calculate(Operation operation, Number... numbers) {
        return Arrays
            .stream(numbers)
            .reduce(operation::execute)
            .orElseThrow(() -> new IllegalArgumentException("피연산자는 1개 이상이어야합니다."));
    }

}
