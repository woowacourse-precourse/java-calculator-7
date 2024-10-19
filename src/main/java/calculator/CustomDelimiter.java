package calculator;

public class CustomDelimiter implements Delimiter {
    private String delimiter;

    public CustomDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public String[] split(String input) {
        return input.split(delimiter);
    }
}
