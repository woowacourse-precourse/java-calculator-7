package calculator.model.delimiter;

public class CustomDelimiter implements Delimiter {
    private static final String DELIMITER_PREFIX = "//";
    private static final String DELIMITER_SUFFIX = "\\n";
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
        return input.startsWith(DELIMITER_PREFIX) && input.contains(DELIMITER_SUFFIX);
    }

    private String extractDelimiter(String input) {
        int newLineIndex = input.indexOf(DELIMITER_SUFFIX);

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
        return DELIMITER_PREFIX + delimiter + DELIMITER_SUFFIX;
    }
}
