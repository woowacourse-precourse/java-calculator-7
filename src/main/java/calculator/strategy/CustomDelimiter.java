package calculator.strategy;

public class CustomDelimiter implements Delimiter {

    private final String delimiter;

    public CustomDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public String[] split(String input) {
        return input.split(delimiter);
    }
}
