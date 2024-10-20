package calculator.domain;

import java.util.List;

public class Calculator {

    private final Splitter splitter;

    public Calculator() {
        this.splitter = new Splitter();
    }

    public int calculate(String input) {
        List<String> invalidNumbers = splitter.split(input);

        PositiveNumbers numbers = new PositiveNumbers(invalidNumbers);
        return numbers.calculateSum();
    }
}
