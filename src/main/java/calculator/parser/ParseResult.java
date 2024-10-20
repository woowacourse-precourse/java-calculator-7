package calculator.parser;

public class ParseResult {
    private final String[] numbers;
    private final String delimiter;

    public ParseResult(String[] numbers, String delimiter) {
        this.numbers = numbers;
        this.delimiter = delimiter;
    }

    public String[] getNumbers() {
        return numbers;
    }
    public String getDelimiter() {
        return delimiter;
    }
}
