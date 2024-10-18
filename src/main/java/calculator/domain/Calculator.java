package calculator.domain;

public class Calculator {

    private final Numbers numbers;

    public Calculator(Numbers numbers) {
        this.numbers = numbers;
    }

    public int sum() {
        return numbers.sum();
    }
}
