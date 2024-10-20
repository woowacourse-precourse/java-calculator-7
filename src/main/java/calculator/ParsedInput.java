package calculator;

public class ParsedInput {
    private final String input;
    private final String delimiter;

    public ParsedInput(String input, String delimiter) {
        this.input = input;
        this.delimiter = delimiter;
    }

    public String getInput() {
        return input;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
