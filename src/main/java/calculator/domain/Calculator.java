package calculator.domain;

import java.util.List;

public class Calculator {
    private int result;
    private final List<Integer> parsedNumbers;

    public Calculator(List<Integer> parsedNumbers) {
        this.parsedNumbers = parsedNumbers;
    }

    public int sum() {
        this.result = 0;
        this.parsedNumbers.forEach(num -> {
            this.result += num;
        });
        return this.result;
    }
}
