package calculator.model;

public class DelimiterExtractionResult {
    private final String delimiter;
    private final String numbers;

    public DelimiterExtractionResult(String delimiter, String numbers) {
        this.delimiter = delimiter;
        this.numbers = numbers;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public String getNumbers() {
        return numbers;
    }
}