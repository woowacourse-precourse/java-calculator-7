package calculator;

public class Delimiter {

    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_END = "\\n";

    public String findDelimiter(String input) {
        String customDelimiter = extractCustomDelimiter(input);
        if (customDelimiter.isEmpty()) {
            return DEFAULT_DELIMITERS;
        }
        return DEFAULT_DELIMITERS + "|" + customDelimiter;
    }

    public String extractCustomDelimiter(String input) {
        if (input.contains(CUSTOM_DELIMITER_START) && input.contains(CUSTOM_DELIMITER_END)) {
            int startIndex = input.indexOf(CUSTOM_DELIMITER_START) + CUSTOM_DELIMITER_START.length();
            int endIndex = input.indexOf(CUSTOM_DELIMITER_END);

            return input.substring(startIndex, endIndex);
        }
        return "";
    }
}