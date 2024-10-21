package calculator.domain;

public class Calculator {
    private String delimeter;
    private String[] numbers;

    public Calculator(String delimeter, String[] numbers) {
        this.delimeter = delimeter;
        this.numbers = numbers;
    }

    public String[] getNumbers() {
        return numbers;
    }
}
