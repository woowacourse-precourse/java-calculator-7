package calculator;

public class DelimiterParser {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    public String parse(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int delimiterIndex = findDelimiterIndex(input);
            String customDelimiter = input.substring(CUSTOM_DELIMITER_PREFIX.length(), delimiterIndex);

            return join(customDelimiter);
        }
        return DEFAULT_DELIMITER;
    }

    public String extractNumbers(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int delimiterIndex = findDelimiterIndex(input);
            String substring = input.substring(delimiterIndex + CUSTOM_DELIMITER_SUFFIX.length());
            return substring;
        }
        return input;
    }

    private int findDelimiterIndex(String input) {
        int delimiterIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        if (delimiterIndex == -1) {
            throw new IllegalArgumentException("\"\\n\" 문자가 존재하지 않습니다.");
        }
        return delimiterIndex;
    }

    private String join(String customDelimiter) {
        return DEFAULT_DELIMITER + "|" + String.join("|", customDelimiter.split(""));
    }
}
