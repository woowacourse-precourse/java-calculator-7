package calculator;

public class Parser {
    private static final String DEFAULT_DELIMITER_PREFIX = "//";

    private boolean hasCustomDelimiter(String input) {
        return input != null && input.startsWith(DEFAULT_DELIMITER_PREFIX);
    }
}
