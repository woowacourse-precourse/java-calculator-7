package calculator.parser;

public class DelimiterExtractor {

    private static final String DEFAULT_DELIMITER = "[,:]";

    public String getDefaultDelimiter() {
        return DEFAULT_DELIMITER;
    }

    public String extractCustomDelimiter(String input) {
        return String.valueOf(input.charAt(2));
    }
}
