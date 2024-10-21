package calculator.domain;

public class Calculator {
    private String delimiter;
    private String numbers;

    public Calculator(String numbers) {
        this.numbers = numbers;
        this.delimiter = ",|:";
    }

    public Calculator(String delimiter, String numbers) {
        this.delimiter = delimiter;
        this.numbers = numbers;
    }

    public String getNumbers() {
        return numbers;
    }
    public String getDelimiter() {
        return delimiter;
    }
}
