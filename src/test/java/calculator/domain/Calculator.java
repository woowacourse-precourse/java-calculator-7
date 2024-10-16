package calculator.domain;

import java.util.List;

public class Calculator {
    // 계산기에서는 숫자만 다룬다.
    private final List<Integer> numbers;

    private Calculator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int calculateSum() {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}