package calculator;

public class ExpressionDto {
    private final String input;
    private final String delimiter;

    public ExpressionDto(String input, String delimiter) {
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
