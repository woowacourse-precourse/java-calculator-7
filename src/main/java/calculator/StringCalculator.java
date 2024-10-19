package calculator;

public class StringCalculator {
    private Delimiter delimiter;

    public StringCalculator() {
        this.delimiter = new BasicDelimiter();
    }

    public StringCalculator(String customDelimiter) {
        this.delimiter = new CustomDelimiter(customDelimiter);
    }


}
