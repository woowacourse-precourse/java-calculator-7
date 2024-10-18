package calculator;

public class StringSplitter {

    private static final String DEFAULT_DELIMITERS = "[,:]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String DELIMITER_END = "\\n";

    public String[] split(String input) {
        if (input == null || input.isEmpty()) {
            return new String[0];
        }

        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            String customDelimiter = extractCustomDelimiter(input);
            int contentStartIndex = input.indexOf(DELIMITER_END) + DELIMITER_END.length();
            return input.substring(contentStartIndex)
                    .split(customDelimiter);
        }

        return input.split(DEFAULT_DELIMITERS);
    }

    private String extractCustomDelimiter(String input) {
        int startIndex = CUSTOM_DELIMITER_PREFIX.length();
        int endIndex = input.indexOf(DELIMITER_END);
        return input.substring(startIndex, endIndex);
    }
}
