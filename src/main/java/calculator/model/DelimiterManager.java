package calculator.model;

import java.util.regex.Pattern;

public class DelimiterManager {

    private String delimiter;
    private static final String DEFAULT_DELIMITER = ",|:";

    public DelimiterManager() {
        this.delimiter = DEFAULT_DELIMITER;
    }

    public void addCustomDelimiter(String customDelimiter) {
        delimiter += "|" + Pattern.quote(customDelimiter);
    }

    public String getDelimiter() {
        return delimiter;
    }
}
