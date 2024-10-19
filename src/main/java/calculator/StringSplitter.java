package calculator;

public class StringSplitter {

    private static final String DEFAULT_DELIMITERS = ",:";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String DELIMITER_END = "\\n";

    public String[] split(String input) {
        if (input == null || input.isEmpty()) {
            return new String[0];
        }

        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            String customDelimiter = extractCustomDelimiter(input);
            int contentStartIndex = input.indexOf(DELIMITER_END) + DELIMITER_END.length();
            String combinedDelimiters = combineDelimiters(customDelimiter);
            return input.substring(contentStartIndex)
                    .split(combinedDelimiters);
        }

        return input.split("[" + DEFAULT_DELIMITERS + "]");
    }

    private String extractCustomDelimiter(String input) {
        int startIndex = CUSTOM_DELIMITER_PREFIX.length();
        int endIndex = input.indexOf(DELIMITER_END);
        String customDelimiter = input.substring(startIndex, endIndex);
        ExceptionHandler.handleInvalidDelmiter(customDelimiter);
        return customDelimiter;
    }

    private String combineDelimiters(String customDelimiter) {
        StringBuilder combinedDelimiters = new StringBuilder(DEFAULT_DELIMITERS);
        for (char delimiter : customDelimiter.toCharArray()) {
            combinedDelimiters.append(escapeRegexChars(delimiter));
        }
        return "[" + combinedDelimiters + "]";
    }

    private String escapeRegexChars(char delimiter) {
        if (delimiter == '[' || delimiter == ']' || delimiter == '\\') {
            return "\\" + delimiter;
        }
        return Character.toString(delimiter);
    }
}
