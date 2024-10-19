package calculator.global.util;

public class DefaultDelimiterExtractor extends DelimiterExtractor {

    private final String delimiter;

    public DefaultDelimiterExtractor(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    String extractDelimiter(String input) {
        return delimiter;
    }

    @Override
    boolean isApplicable(String input) {
        return Character.isDigit(input.charAt(0));
    }
}
