package calculator.model;

public class DelimiterExtractor {
    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER_PREFIX = "//";
    public static final String NEWLINE = "\\n";

    public static DelimiterExtractionResult extractDelimiterAndNumbers(String input) {
        String delimiter = DEFAULT_DELIMITER;
        String numbers = input;

        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int delimiterIndex = input.indexOf(NEWLINE);
            String customDelimiter = input.substring(2, delimiterIndex);
            delimiter = DEFAULT_DELIMITER + "|" + customDelimiter;
            numbers = input.substring(delimiterIndex + NEWLINE.length());
        }

        return new DelimiterExtractionResult(delimiter, numbers);
    }
}
