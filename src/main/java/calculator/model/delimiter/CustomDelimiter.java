package calculator.model.delimiter;

public class CustomDelimiter implements Delimiter {
    private static final String DELIMITER_PREFIX = "//";
    private static final String NEW_LINE = "\\n";
    private static final int PREFIX_LENGTH = 2;
    private static final String EMPTY = "";

    private final String delimiter;

    public CustomDelimiter(String input) {
        this.delimiter = parseDelimiter(input);
    }

    private String parseDelimiter(String input) {
        if (isApplicable(input)) {
            return extractDelimiter(input);
        }
        return EMPTY;
    }

    public boolean isApplicable(String input) {
        return input.startsWith(DELIMITER_PREFIX) && input.contains(NEW_LINE);
    }

    private String extractDelimiter(String input) {
        int newLineIndex = input.indexOf(NEW_LINE);
        return input.substring(PREFIX_LENGTH, newLineIndex);
    }

    @Override
    public String getDelimiter() {
        return delimiter;
    }

    @Override
    public boolean isCustomDelimiter() {
        return true;
    }

    public String getCustomDelimiterPattern() {
        return DELIMITER_PREFIX + delimiter + NEW_LINE;
    }
}
