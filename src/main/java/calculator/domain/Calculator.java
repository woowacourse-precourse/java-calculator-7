package calculator.domain;

import java.util.List;

public class Calculator {

    private List<Number> numbers;

    public Calculator(List<Number> numbers) {
        this.numbers = numbers;
    }

    public Integer calculateNumbersSum() {
        return numbers.stream().mapToInt(Number::getNumber).sum();
    }

}
