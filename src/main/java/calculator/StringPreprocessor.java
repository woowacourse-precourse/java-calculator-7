package calculator;

public class StringPreprocessor {
    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_END = "\\n";

    public String removeDelimiterPart(String input) {
        if (input == null || input.isEmpty()) {
            return "0";
        }

        if (input.startsWith(CUSTOM_DELIMITER_START) && input.contains(CUSTOM_DELIMITER_END)) {
            int endIndex = input.indexOf(CUSTOM_DELIMITER_END);
            return input.substring(endIndex + CUSTOM_DELIMITER_END.length());
        }
        return input;
    }
}