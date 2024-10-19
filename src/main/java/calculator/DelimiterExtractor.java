package calculator;

import java.util.regex.Pattern;

public class DelimiterExtractor {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private final String inputString;
    private final String delimiter;

    public DelimiterExtractor(String inputString) {
        this.inputString = inputString;
        this.delimiter = extractCustomDelimiter();
    }

    private String extractCustomDelimiter() {
        if (hasCustomDelimiter()) {
            String customDelimiter = inputString.substring(2, inputString.indexOf("\\n"));
            return DEFAULT_DELIMITER + "|" + Pattern.quote(customDelimiter);
        }
        return DEFAULT_DELIMITER;
    }

    public boolean hasCustomDelimiter() {
        return inputString.startsWith("//") && inputString.contains("\\n");
    }

    public String getDelimiter() {
        return delimiter;
    }
}
