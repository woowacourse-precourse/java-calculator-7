package calculator.strategy;

public class CustomDelimiter implements Delimiter {

    private final String delimiter;

    public CustomDelimiter(String delimiter) {
        this.delimiter = escapeCustomDelimiter(delimiter);
    }

    @Override
    public String[] split(String input) {
        return input.split(delimiter, -1);
    }

    private String escapeCustomDelimiter(String delimiter) {
        return delimiter.replaceAll("([.*+?^$()\\[\\]{}|\\\\])", "\\\\$1");
    }
}
