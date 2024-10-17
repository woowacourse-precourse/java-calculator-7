package calculator;

public class Numbers {
    private String numbers;

    public Numbers(String input) {
        InputPattern inputPattern = InputPattern.match(input);
        this.numbers = inputPattern.extractNumbers(input);
    }

    public String getNumbers() {
        return numbers;
    }
}
