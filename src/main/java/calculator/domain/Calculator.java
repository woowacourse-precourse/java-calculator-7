package calculator.domain;

public class Calculator {
    private String[] numbers;

    public Calculator(String[] numbers) {
        this.numbers = numbers;
    }

    public String[] getNumbers() {
        return numbers;
    }
}
